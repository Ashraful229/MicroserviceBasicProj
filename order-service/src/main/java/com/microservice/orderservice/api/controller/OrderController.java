package com.microservice.orderservice.api.controller;

import com.microservice.orderservice.api.entity.Order;
import com.microservice.orderservice.api.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public Order bookOrder(@RequestBody Order order)
    {
       return this.orderService.saveOrder(order);
    }
}
