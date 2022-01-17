package com.microservice.orderservice.api.service;

import com.microservice.orderservice.api.entity.Order;
import com.microservice.orderservice.api.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public Order saveOrder(Order order)
    {
       return orderRepo.save(order);
    }
}
