package com.example.order;

import com.example.common.ProductView;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
class ProductClient {
    private final WebClient webClient;

    ProductClient(WebClient.Builder builder, ProductClientProperties properties) {
        this.webClient = builder.baseUrl(properties.baseUrl()).build();
    }

    ProductView getProduct(Long productId) {
        return webClient.get()
                .uri("/products/{id}", productId)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new ProductUnavailableException(productId)))
                .bodyToMono(ProductView.class)
                .block();
    }
}
