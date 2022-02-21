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
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

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
    @CircuitBreaker(name ="customer", fallbackMethod="getCustomerFallback")
    @Bulkhead(name = "customer",type = Bulkhead.Type.SEMAPHORE, fallbackMethod = "getCustomerFallback")
    public Customer retrieveCustomer(String userid) throws Exception{
        return restTemplate.getForObject(CUSTOMER_API_URL+
        "/api/customer/"+userid, Customer.class);
    }

    public Customer getCustomerFallback(String userId, BulkheadFullException bulkheadFullException) throws Exception{
        String msg = "Error: "+userId+"에 해당하는 고객 정보 조회가 지연되고 있습니다.";
        System.out.println(msg);
        throw new Exception();
    }
}
