package com.microservice.orderservice.api.repository;

import com.microservice.orderservice.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
