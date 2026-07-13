package com.example.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties = "product-client.base-url=http://localhost:19001")
@ActiveProfiles("test")
class OrderControllerTests {
    @Autowired
    private OrderRepository orders;

    @Test
    void persistsOrderTotals() {
        Order saved = orders.save(new Order(1L, "Mechanical Keyboard", 2, new BigDecimal("89.99")));

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getTotal()).isEqualByComparingTo("179.98");
    }
}
