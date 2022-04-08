package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.repository.CustomerRepository;
import com.codegym.casestudy.repository.CustomerTypeRepository;
import com.codegym.casestudy.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerTypes = customerTypeRepository.findAll();
        return customerTypeRepository.findAll();
    }
}
