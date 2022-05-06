package com.supham.doantotnghiep.service;

import com.supham.doantotnghiep.model.ProductType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductTypeService {
    List<ProductType> findAll();
}
