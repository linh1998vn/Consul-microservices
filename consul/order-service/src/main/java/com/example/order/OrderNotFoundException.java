package com.example.order;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class OrderNotFoundException extends RuntimeException {
    OrderNotFoundException(Long id) {
        super("Order %d was not found".formatted(id));
    }
}
