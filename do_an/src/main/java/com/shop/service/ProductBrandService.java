package com.shop.service;

import com.shop.model.ProductBrand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProductBrandService {
    Page<ProductBrand> findAll(Pageable pageable);
    void saveProductBrand(ProductBrand productBrand);
    void deleteProductBrand(int id);
    Optional<ProductBrand> findProductBrandById(int id);
    List<ProductBrand> findAll();
    Page<ProductBrand> findProductBrandByNameContaining(String name,Pageable pageable);

}

