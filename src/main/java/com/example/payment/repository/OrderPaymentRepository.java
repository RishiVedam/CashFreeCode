package com.example.payment.repository;

import com.example.payment.entity.OrderPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPaymentRepository extends JpaRepository<OrderPaymentEntity,Long> {

    boolean existsByPaymentIdAndPaymentStatus(String paymentId, String paymentStatus);
}
