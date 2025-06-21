package com.example.payment.entity;

import com.example.payment.dto.FeeType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id                                       // ← becomes PK
    @Column(name = "order_id", length = 64)
    private String orderId;

    @Enumerated(EnumType.STRING)
    private FeeType feeType;

    private String cashfreeAccount;


    private String customerId;
    private Double  orderAmount;
    private String  currency;
    private String  customerEmail;
    private String  customerPhone;
    private String  customerName;
    private String  sessionId;
    private String  status;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderPaymentEntity> payments;
}
