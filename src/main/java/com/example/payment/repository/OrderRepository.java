package com.example.payment.repository;

import com.example.payment.dto.FeeType;
import com.example.payment.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
    OrderEntity findTopByCustomerEmailOrderByCreatedAtDesc(String email);

    OrderEntity findByOrderId(String orderId);

    Optional<OrderEntity> findByCustomerId(String customerId);

    List<OrderEntity> findByStatus(String status);

    Optional<OrderEntity> findTopByCustomerIdAndSessionIdIsNullOrderByCreatedAtDesc(String customerId);

    Optional<OrderEntity> findByCustomerIdAndFeeType(String customerId, FeeType feeType);

    boolean existsByCustomerIdAndFeeTypeAndStatus(String customerId, FeeType feeType, String success);
}

