package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.repository.CustomerRepository;
import com.codegym.casestudy.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerRepository customerTypeRepository;
    @Override
    public List<Customer> findAll() {
        return customerTypeRepository.findAll();
    }
}
