package com.codegym.them_san_pham_vao_gio_hang.service;

import com.codegym.them_san_pham_vao_gio_hang.model.Product;
import com.codegym.them_san_pham_vao_gio_hang.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
    public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }


    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
