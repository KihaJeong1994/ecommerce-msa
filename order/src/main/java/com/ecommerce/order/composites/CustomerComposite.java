package com.ecommerce.order.composites;

import java.util.concurrent.TimeoutException;

import com.ecommerce.order.model.Customer;

import io.github.resilience4j.bulkhead.BulkheadFullException;

public interface CustomerComposite {
    public Customer retrieveCustomer(String userid) throws Exception;
    public Customer getCustomerFallback(String userid, BulkheadFullException bException) throws Exception;
}
