package com.codegym.quan_ly_khach_hang.service;

import com.codegym.quan_ly_khach_hang.model.Customer;
import com.codegym.quan_ly_khach_hang.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }


    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }


    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
