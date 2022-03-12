package com.codegym.quan_ly_khach_hang.repository;

import com.codegym.quan_ly_khach_hang.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer where firstName like %?%",nativeQuery = true)
    List<Customer> findByName(String name);
}