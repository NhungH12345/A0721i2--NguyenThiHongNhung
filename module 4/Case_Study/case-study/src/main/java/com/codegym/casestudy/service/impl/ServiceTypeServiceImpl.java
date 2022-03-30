package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeService serviceTypeRepository;
    @Override
    public List<javax.xml.ws.Service> findAll() {
        return serviceTypeRepository.findAll();
    }
}
