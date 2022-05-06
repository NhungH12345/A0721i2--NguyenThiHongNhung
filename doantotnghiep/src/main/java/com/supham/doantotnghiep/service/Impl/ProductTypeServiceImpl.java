package com.supham.doantotnghiep.service.Impl;

import com.supham.doantotnghiep.model.ProductType;
import com.supham.doantotnghiep.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductType productType;

    @Override
    public List<ProductType> findAll() {
        return null;
    }
}
