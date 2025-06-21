package com.example.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order{
    public String order_id;
    public double order_amount;
    public String order_currency;
    public Object order_tags;
}
