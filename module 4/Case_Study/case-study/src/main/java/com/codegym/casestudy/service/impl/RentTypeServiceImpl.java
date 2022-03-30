package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.RentType;
import com.codegym.casestudy.repository.RentTypeRepository;
import com.codegym.casestudy.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
