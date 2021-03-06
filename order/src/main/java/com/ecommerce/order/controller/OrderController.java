package com.ecommerce.order.controller;

import java.util.List;
import java.util.UUID;

import com.ecommerce.order.model.Orders;
import com.ecommerce.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class OrderController {
    
    @Autowired
    OrderService orderService;




    @GetMapping("/orders/{userid}")
    public List<Orders> selectOrderByUserid(@PathVariable("userid") String userid){
        return orderService.selectOrderByUserid(userid);
    }

    @PostMapping("/orders")
    public Mono<Orders> insertOrder(@RequestBody Orders orders) throws Exception{
        // orders.setOrderId(UUID.randomUUID().toString());
        return Mono.just(orderService.insertOrder(orders));
        // return orderService.insertOrder(orders);
    }


}
