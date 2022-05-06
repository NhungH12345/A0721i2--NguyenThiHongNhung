package com.supham.doantotnghiep.service.Impl;

import com.supham.doantotnghiep.model.ProductBrand;
import com.supham.doantotnghiep.service.ProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductBrandServiceImpl implements ProductBrandService {
    @Autowired
    private ProductBrand productBrand;

    @Override
    public List<ProductBrand> findAll() {
        return null;
    }
}
