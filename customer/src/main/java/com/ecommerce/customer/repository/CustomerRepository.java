package com.ecommerce.customer.repository;

import java.util.Optional;

import com.ecommerce.customer.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

    Optional<Customer> findByUserid(String userid);
}