package com.codegym.jpa_store_procedured.repository;

import com.codegym.jpa_store_procedured.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}
