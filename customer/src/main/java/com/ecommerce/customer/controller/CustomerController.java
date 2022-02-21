package com.ecommerce.customer.controller;

import java.util.List;
import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Value("${server.port}")
    String port;
    
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> selectAllCustomer(){
        System.out.println("---------customer selectAllCustomer 호출----------");
        System.out.println("---------customer selectAllCustomer port"+port+"----------");
        return customerService.selectAllCustomer();
    }

    @GetMapping("/customer/{userId}")
    public Customer selectCustomerByUserid(@PathVariable String userId) throws InterruptedException{
        Thread.sleep(3000);
        return customerService.selectCustomerByUserid(userId);
    }

    @GetMapping("/customer/{userid}/exists")
    public boolean existsCustomer(@PathVariable("userid") String userid){
        boolean result = false;
        if(!(customerService.selectCustomerByUserid(userid).getUserid()==null)){
            result = true;
        }
        return result;
    }

    @PostMapping("/customer")
    public Customer insertCustomer(@RequestBody Customer customer){
        return customerService.insertCustomer(customer);
    }
}
