package com.example.order;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "product-client")
record ProductClientProperties(String baseUrl) {
}
