package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.repository.ServiceRepository;
import com.codegym.casestudy.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public List<com.codegym.casestudy.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void saveService(com.codegym.casestudy.model.Service service) {
        serviceRepository.save(service);

    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);

    }

    @Override
    public com.codegym.casestudy.model.Service findServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }
}
