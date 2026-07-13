package com.example.product;

import com.example.common.ProductView;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
class ProductController {
    private final ProductRepository products;

    ProductController(ProductRepository products) {
        this.products = products;
    }

    @GetMapping
    List<ProductView> list() {
        return products.findAll().stream().map(ProductController::toView).toList();
    }

    @GetMapping("/{id}")
    ProductView get(@PathVariable Long id) {
        return products.findById(id).map(ProductController::toView)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping
    ResponseEntity<ProductView> create(@Valid @RequestBody CreateProductRequest request) {
        Product saved = products.save(new Product(request.name(), request.price()));
        return ResponseEntity.created(URI.create("/products/" + saved.getId())).body(toView(saved));
    }

    private static ProductView toView(Product product) {
        return new ProductView(product.getId(), product.getName(), product.getPrice());
    }

    record CreateProductRequest(
            @NotBlank String name,
            @DecimalMin(value = "0.01") BigDecimal price
    ) {
    }
}
