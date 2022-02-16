package com.ecommerce.order.composites;

import com.ecommerce.order.model.Customer;

public interface CustomerComposite {
    public Customer retrieveCustomer(String userid) throws Exception;
}
