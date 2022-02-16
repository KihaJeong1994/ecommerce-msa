package com.ecommerce.order.composites;

import com.ecommerce.order.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerCompositeImpl implements CustomerComposite{

    @Value("${customer.api.url}")
    private String CUSTOMER_API_URL;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Customer retrieveCustomer(String userid) throws Exception{
        return restTemplate.getForObject(CUSTOMER_API_URL+
        "/api/customer/"+userid, Customer.class);
    }
}
