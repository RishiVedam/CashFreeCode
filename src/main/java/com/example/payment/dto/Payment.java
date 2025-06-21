package com.example.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment{
    public long cf_payment_id;
    public String payment_status;
    public double payment_amount;
    public String payment_currency;
    public String payment_message;
    public Date payment_time;
    public String bank_reference;
    public Object auth_id;
    public PaymentMethod payment_method;
    public String payment_group;
}