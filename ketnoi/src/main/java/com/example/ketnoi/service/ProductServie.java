package com.example.ketnoi.service;

import com.example.ketnoi.model.Category;
import com.example.ketnoi.model.Product;
import com.example.ketnoi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServie {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

//    public List<Product> getProductById(String id) {
//        return productRepository.getProductById(id);
//    }


}
