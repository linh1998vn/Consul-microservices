package com.example.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class ProductControllerTests {
    @Autowired
    private ProductRepository products;

    @Test
    void loadsSeededProducts() {
        assertThat(products.findAll()).hasSize(3);
    }
}
