package com.supham.doantotnghiep.service;

import com.supham.doantotnghiep.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    void saveProduct(Product product);
    void deleteProduct(long id);
    Optional<Product> findProductById(long id);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
