package com.codegym.jpa_store_procedured.service;

import com.codegym.jpa_store_procedured.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}

