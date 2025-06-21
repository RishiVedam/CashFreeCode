package com.example.payment.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class WebHookPayload {

    private PayloadData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PayloadData {
        private Order order;
        private Payment payment;

        @JsonProperty("customer_details")
        private CustomerDetails customerDetails;
    }
}
