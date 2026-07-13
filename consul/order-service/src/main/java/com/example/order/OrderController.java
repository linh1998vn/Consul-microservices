package com.example.order;

import com.example.common.OrderView;
import com.example.common.ProductView;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
@RequestMapping("/orders")
class OrderController {
    private final OrderRepository orders;
    private final ProductClient products;

    OrderController(OrderRepository orders, ProductClient products) {
        this.orders = orders;
        this.products = products;
    }

    @GetMapping
    List<OrderView> list() {
        return orders.findAll().stream().map(OrderController::toView).toList();
    }

    @GetMapping("/{id}")
    OrderView get(@PathVariable Long id) {
        return orders.findById(id).map(OrderController::toView)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @PostMapping
    ResponseEntity<OrderView> create(@Valid @RequestBody CreateOrderRequest request) {
        ProductView product = products.getProduct(request.productId());
        Order saved = orders.save(new Order(product.id(), product.name(), request.quantity(), product.price()));
        return ResponseEntity.created(URI.create("/orders/" + saved.getId())).body(toView(saved));
    }

    private static OrderView toView(Order order) {
        return new OrderView(
                order.getId(),
                order.getProductId(),
                order.getProductName(),
                order.getQuantity(),
                order.getUnitPrice(),
                order.getTotal(),
                order.getCreatedAt()
        );
    }

    record CreateOrderRequest(
            @NotNull Long productId,
            @NotNull @Min(1) Integer quantity
    ) {
    }
}
