package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findAll(Pageable pageable);
    @Query(value = "select * from customer where customer_name like %?%", nativeQuery = true)
    Page<Customer> searchCustomer_Name(String customer_name, Pageable pageable);

}
