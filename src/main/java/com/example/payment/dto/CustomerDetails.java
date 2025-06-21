package com.example.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails{
    public String customer_name;
    public String customer_id;
    public String customer_email;
    public String customer_phone;
}