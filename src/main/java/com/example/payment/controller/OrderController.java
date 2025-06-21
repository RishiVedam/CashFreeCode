package com.example.payment.controller;

import com.example.payment.dto.CreateOrderRequest;
import com.example.payment.dto.SaveCustomerRequest;
import com.example.payment.dto.WebHookPayload;
import com.example.payment.entity.OrderEntity;
import com.example.payment.repository.OrderRepository;
import com.example.payment.service.CashfreeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    @Autowired
    CashfreeService cashfreeService;

    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveCustomer(@RequestBody SaveCustomerRequest request) {
        log.info( "Saving user to DB");

        cashfreeService.saveCustomer(request);
    return ResponseEntity.ok(Map.of("message", "Customer saved successfully"));
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest request) {
        log.info("{}", Map.of("message", "Creating order", "level", "INFO"));
        return ResponseEntity.ok(cashfreeService.createOrder(request));
    }

    @GetMapping("/{orderId}/verify")
    public ResponseEntity<?> getOrderStatus(@PathVariable String orderId) {
        log.info("goining to find order using orderId");
        OrderEntity order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            log.info("not found order with given orderId");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No order found for this orderId");
        }

        cashfreeService.updatePaymentStatus(order.getOrderId());

        OrderEntity updatedOrder = orderRepository.findByOrderId(order.getOrderId());

        if (updatedOrder.getStatus() != null) {
            return ResponseEntity.ok(Map.of("status", updatedOrder.getStatus()));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("status", "Could not retrieve payment status."));
        }
    }

    @PostMapping("/status/webhook")
    public ResponseEntity<Void> getWebhookStatus(@RequestBody WebHookPayload payload)
    {

        String orderId       = payload.getData().getOrder().order_id;
        String paymentStatus = payload.getData().getPayment().payment_status;

        OrderEntity order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            log.warn("Webhook received for unknown orderId={}", orderId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        order.setStatus(paymentStatus);
        orderRepository.save(order);

        log.atInfo()
                .addKeyValue("orderId", orderId)
                .addKeyValue("paymentStatus", paymentStatus)
                .addKeyValue("feeType", order.getFeeType())
                .addKeyValue("account", order.getCashfreeAccount())
                .log();

        return ResponseEntity.ok().build();
    }

}
