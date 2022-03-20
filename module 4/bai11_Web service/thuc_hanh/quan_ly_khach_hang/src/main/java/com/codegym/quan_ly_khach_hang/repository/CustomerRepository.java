package com.codegym.quan_ly_khach_hang.repository;

import com.codegym.quan_ly_khach_hang.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
