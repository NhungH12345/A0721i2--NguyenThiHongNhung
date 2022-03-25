package com.codegym.quan_ly_tinh.service;

import com.codegym.quan_ly_tinh.model.Customer;
import com.codegym.quan_ly_tinh.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}

