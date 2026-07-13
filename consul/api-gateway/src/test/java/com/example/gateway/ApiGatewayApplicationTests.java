package com.example.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        properties = {
                "spring.cloud.consul.enabled=false",
                "PRODUCT_SERVICE_URL=http://localhost:8081",
                "ORDER_SERVICE_URL=http://localhost:8082"
        }
)
class ApiGatewayApplicationTests {
    @Test
    void contextLoads() {
    }
}
