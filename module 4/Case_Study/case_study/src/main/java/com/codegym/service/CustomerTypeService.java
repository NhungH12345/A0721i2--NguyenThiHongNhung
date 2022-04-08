package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType>  findAll();
}
