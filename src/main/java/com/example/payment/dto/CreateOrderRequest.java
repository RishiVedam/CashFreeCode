package com.example.payment.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private Double orderAmount;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerId;

    private FeeType feeType;
}




