package com.ecommerce.order.repository;

import java.util.List;
import java.util.Optional;

import com.ecommerce.order.model.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer>{


    List<Orders> findAllByUserId(String userid);
}