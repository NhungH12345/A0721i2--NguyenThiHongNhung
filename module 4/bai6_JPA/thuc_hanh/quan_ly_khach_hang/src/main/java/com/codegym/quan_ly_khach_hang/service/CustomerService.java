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

    public List<Customer> findAll() {
        return customerRepository.findAll();

    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
