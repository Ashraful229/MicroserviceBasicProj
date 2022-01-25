package com.microservice.orderservice.api.service;

import com.microservice.orderservice.api.common.Payment;
import com.microservice.orderservice.api.common.TransactionRequest;
import com.microservice.orderservice.api.common.TransactionResponse;
import com.microservice.orderservice.api.entity.Order;
import com.microservice.orderservice.api.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private RestTemplate template;

    public TransactionResponse saveOrder(TransactionRequest request )
    {
        String response="";
        Order order=request.getOrder();
        Payment payment=request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call
        Payment paymentResponse=  template.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
        response= paymentResponse.getPaymentStatus().equals("Success")?"payment  processing successfully":"there is a problem in payment api, order added to cart";
        orderRepo.save(order);
      // return  null;
        return  new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}
