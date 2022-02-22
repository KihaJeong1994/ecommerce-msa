package com.ecommerce.customer.service;



import java.util.List;

import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    @CircuitBreaker(name = "example")
    public Customer insertCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    public Customer selectCustomerByUserid(String userid){
        return customerRepository.findByUserid(userid).orElseGet(()->{
                return new Customer();
            }
        );
    }

    public List<Customer> selectAllCustomer(){
        return customerRepository.findAll();
    }
}
