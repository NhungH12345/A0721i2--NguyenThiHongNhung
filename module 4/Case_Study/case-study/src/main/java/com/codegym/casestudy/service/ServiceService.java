package com.codegym.casestudy.service;


import com.codegym.casestudy.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);
    void saveService(Service service);
    void deleteService(int id);
    Optional<Service> findServiceById(int id);
    Page<Service> findAllByNameContaining(String name, Pageable pageable);

    Object findAll();
}


