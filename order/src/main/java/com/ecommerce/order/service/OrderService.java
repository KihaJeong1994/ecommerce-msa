package com.ecommerce.order.service;




import java.util.List;

import com.ecommerce.order.composites.CustomerComposite;
import com.ecommerce.order.model.Customer;
import com.ecommerce.order.model.Orders;
import com.ecommerce.order.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.core.subst.Token.Type;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@Service("orderService")
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    
    @Autowired
    CustomerComposite customerComposite;

    
    @Transactional(readOnly = true)
    public List<Orders> selectOrderByUserid(String userid){
        return orderRepository.findAllByUserId(userid);
    }

    @Transactional
    public Orders insertOrder(Orders order) throws Exception{
        Customer customer = customerComposite.retrieveCustomer(order.getUserId());
        order.setName(customer.getName());
        System.out.println("Customer>>"+customer);

        return orderRepository.save(order);
    }

    
}
