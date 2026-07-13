package com.example.common;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderView(
        Long id,
        Long productId,
        String productName,
        Integer quantity,
        BigDecimal unitPrice,
        BigDecimal total,
        Instant createdAt
) {
}
