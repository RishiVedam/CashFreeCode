package com.example.payment.config;

import feign.Request;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignCashfreeConfig {

    @Bean
    public Request.Options cashfreeOptions() {
        return new Request.Options(
                10, TimeUnit.SECONDS,   // connect timeout
                30, TimeUnit.SECONDS,   // read timeout
                true                    // follow redirects
        );
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
