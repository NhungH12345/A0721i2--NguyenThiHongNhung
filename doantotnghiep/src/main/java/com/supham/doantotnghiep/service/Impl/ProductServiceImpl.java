package com.supham.doantotnghiep.service.Impl;
import com.supham.doantotnghiep.model.Product;
import com.supham.doantotnghiep.repository.ProductRepository;
import com.supham.doantotnghiep.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);


    }

    @Override
    public Optional<Product> findProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name, pageable);
    }
}
