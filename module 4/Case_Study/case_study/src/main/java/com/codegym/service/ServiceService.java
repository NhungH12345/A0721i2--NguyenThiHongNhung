package com.codegym.casestudy.service;


import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);
    void saveService(Service service);
    void deleteService(Long id);
    void findServiceById(Long id);
    Page<Service> findAllByNameContaining(String name, Pageable pageable);

    Object findAll();
}


