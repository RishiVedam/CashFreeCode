package com.example.payment.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "cashfree")
public class CashfreeConfig {
    private Map<String, Credentials> accounts;

    @Data
    public static class Credentials {
        private String clientId;
        private String clientSecret;
        private String apiBaseUrl;
    }
}
