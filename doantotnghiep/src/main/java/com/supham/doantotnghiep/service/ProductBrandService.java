package com.supham.doantotnghiep.service;

import com.supham.doantotnghiep.model.ProductBrand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductBrandService {
    List<ProductBrand> findAll();

}
