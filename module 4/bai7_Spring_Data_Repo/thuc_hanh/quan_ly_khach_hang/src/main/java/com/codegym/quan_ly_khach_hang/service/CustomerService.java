package com.codegym.quan_ly_khach_hang.service;

import com.codegym.quan_ly_khach_hang.model.Customer;
import com.codegym.quan_ly_khach_hang.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }


    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }


    public void save(Customer customer) {
        customerRepository.save(customer);
    }


    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    public Page<Customer> searchFirstName(String firstName, Pageable pageable) {
        return customerRepository.searchFirstName(firstName, pageable);
    }

}

