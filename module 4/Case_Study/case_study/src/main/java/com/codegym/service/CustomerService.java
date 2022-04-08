package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Optional<Customer>findCustomerById(Long id);
    void saveCustomer(Customer customer);//pt thêm mơi và update(tự hieu gióng id la update)
    void deleteCustomer(Long id);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
