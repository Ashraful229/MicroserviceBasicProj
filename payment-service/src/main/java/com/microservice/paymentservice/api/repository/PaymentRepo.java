package com.microservice.paymentservice.api.repository;

import com.microservice.paymentservice.api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
    Payment findByOrderId(int orderId);
}
