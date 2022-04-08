package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    Page<Service> findAllByNameContaining(String name, Pageable pageable);
}
