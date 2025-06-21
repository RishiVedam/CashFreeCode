package com.example.payment.client;

import com.example.payment.config.FeignCashfreeConfig;
import com.example.payment.dto.CreateOrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "cashfreeClient", url = "https://sandbox.cashfree.com" , configuration = FeignCashfreeConfig.class)
public interface CashfreeClient {

    @PostMapping(value = "/pg/orders", consumes = "application/json")
    CreateOrderResponse createOrder(
            @RequestBody Map<String, Object> body,
            @RequestHeader("x-client-id") String clientId,
            @RequestHeader("x-client-secret") String clientSecret,
            @RequestHeader("x-api-version") String apiVersion
    );

    @GetMapping("/import/transactions/{cf_payment_id}")
    Map<String, Object> getTransactionDetails( // Renamed method
                                               @PathVariable("cf_payment_id") Long cfPaymentId, // Changed type to Long
                                               @RequestHeader("x-client-id") String clientId,
                                               @RequestHeader("x-client-secret") String clientSecret,
                                               @RequestHeader("x-api-version") String apiVersion
    );

    @GetMapping("/pg/orders/{order_id}")
    Map<String, Object> getTransactionDetailsByOrderId(
            @PathVariable("order_id") String orderId,
            @RequestHeader("x-client-id") String clientId,
            @RequestHeader("x-client-secret") String clientSecret,
            @RequestHeader("x-api-version") String apiVersion
    );

    @GetMapping("/pg/orders/{order_id}/payments")
    List<Map<String, Object>> getPaymentsByOrderId(
            @PathVariable("order_id") String orderId,
            @RequestHeader("x-client-id")     String clientId,
            @RequestHeader("x-client-secret") String clientSecret,
            @RequestHeader("x-api-version")   String apiVersion
    );
}

