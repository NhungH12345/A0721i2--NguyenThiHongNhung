package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.ServiceType;
import com.codegym.casestudy.repository.ServiceRepository;
import com.codegym.casestudy.repository.ServiceTypeRepository;
import com.codegym.casestudy.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
