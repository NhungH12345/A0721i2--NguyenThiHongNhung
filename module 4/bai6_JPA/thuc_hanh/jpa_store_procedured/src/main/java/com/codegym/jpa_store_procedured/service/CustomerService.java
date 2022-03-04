package com.codegym.jpa_store_procedured.service;

import com.codegym.jpa_store_procedured.model.Customer;
import com.codegym.jpa_store_procedured.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return customerRepository.insertWithStoredProcedure(customer);
    }
}