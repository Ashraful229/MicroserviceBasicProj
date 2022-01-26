package com.microservice.paymentservice.api.service;

import com.microservice.paymentservice.api.entity.Payment;
import com.microservice.paymentservice.api.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;

    public Payment doPayment(Payment payment)
    {
        payment.setPaymentStatus(isPaymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return this.paymentRepo.save(payment);
    }
    public String isPaymentProcessing()
    {
        return new Random().nextBoolean()?"Success":"False";
    }

    public Payment findPaymentHistoryByOrderId(int orderId) {
        return this.paymentRepo.findByOrderId(orderId);
    }
}
