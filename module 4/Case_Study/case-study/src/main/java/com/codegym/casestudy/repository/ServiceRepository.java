package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {
    Page<Service> findAll(Pageable pageable);
    Page<Service> findAllByNameContaining(String name, Pageable pageable);
}

