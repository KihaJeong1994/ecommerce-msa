package com.ecommerce.order.composites;

import java.util.concurrent.TimeoutException;

import com.ecommerce.order.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;

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
    @Bulkhead(name = "customer",  type = Bulkhead.Type.SEMAPHORE, fallbackMethod = "getCustomerFallback")
    public Customer retrieveCustomer(String userid) throws Exception{
        return restTemplate.getForObject(CUSTOMER_API_URL+
        "/api/customer/"+userid, Customer.class);
    }

    @Override
    public Customer getCustomerFallback(String userid, BulkheadFullException bException) throws Exception{
        String msg = "두개 이상의 요청이 동시에 들어왔습니다.";
        System.out.println(msg);
        throw new Exception();
    }
}
