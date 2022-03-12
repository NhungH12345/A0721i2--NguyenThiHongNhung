package com.codegym.quan_ly_khach_hang.service;

import com.codegym.quan_ly_khach_hang.model.Customer;
import com.codegym.quan_ly_khach_hang.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }


    public void save(Customer customer) {
        customerRepository.save(customer);
    }


    public void remove(int id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }
}
