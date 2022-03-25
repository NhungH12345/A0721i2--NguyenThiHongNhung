package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerServiceImpl {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(long id);

    void save(Customer customer);

    void remove(long id);

    //Page<Customer> findByCustomer_Name(String customer_name);

    Page<Customer> searchByName(String name, Pageable pageable);
}
