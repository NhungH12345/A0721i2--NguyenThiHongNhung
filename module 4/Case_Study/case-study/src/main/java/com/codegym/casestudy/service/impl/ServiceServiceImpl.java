package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.repository.ServiceRepository;
import com.codegym.casestudy.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<com.codegym.casestudy.model.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public void saveService(com.codegym.casestudy.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteService(int id) {
        serviceRepository.deleteById(Math.toIntExact(id));

    }

    @Override
    public Optional<com.codegym.casestudy.model.Service> findServiceById(int id) {
       return serviceRepository.findById(Math.toIntExact(id));
    }
    @Override
    public Object findAll() {
        return null;
    }
    @Override
    public Page<com.codegym.casestudy.model.Service> findAllByNameContaining(String name, Pageable pageable) {
        return serviceRepository.findAllByNameContaining(name, pageable);
    }
}
