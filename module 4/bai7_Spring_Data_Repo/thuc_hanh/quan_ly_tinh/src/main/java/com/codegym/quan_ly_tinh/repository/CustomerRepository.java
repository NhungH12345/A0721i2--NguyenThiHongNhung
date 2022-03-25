package com.codegym.quan_ly_tinh.repository;

import com.codegym.quan_ly_tinh.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.IdGenerator;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
