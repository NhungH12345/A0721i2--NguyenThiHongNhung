package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceImpl {
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Customer findById(long customer_id) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void remove(long customer_id) {

    }

    @Override
    public Page<Customer> searchByName(String name, Pageable pageable) {
        return null;
    }
}
