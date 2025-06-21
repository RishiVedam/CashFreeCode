package com.example.payment.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderResponse {

    @JsonProperty("payment_session_id")
    private String sessionId;

    @JsonProperty("order_id")
    private String orderId;


}

