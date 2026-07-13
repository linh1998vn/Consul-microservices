package com.example.order;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
class ProductUnavailableException extends RuntimeException {
    ProductUnavailableException(Long id) {
        super("Product %d is not available".formatted(id));
    }
}
