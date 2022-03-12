package com.codegym.ung_dung_quan_ly_khach_hang.repository;

import com.codegym.ung_dung_quan_ly_khach_hang.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.firstName like %?1%")
    Page<Customer> getCustomerByFirstName(String firstname);

    void delete(Long id);
}