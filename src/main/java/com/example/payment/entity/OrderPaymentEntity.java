package com.example.payment.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "order_payment",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"payment_id", "payment_status"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderPaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**  FK → orders(order_id)  */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name               = "order_id",
            referencedColumnName = "order_id",
            nullable           = false)
    private OrderEntity order;

    private String paymentId;
    private String paymentStatus;
    private String paymentMethod;
    private String bankReference;
    private String paymentTime;
}
