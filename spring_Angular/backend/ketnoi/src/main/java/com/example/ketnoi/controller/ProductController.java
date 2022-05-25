package com.example.ketnoi.controller;

import com.example.ketnoi.model.Category;
import com.example.ketnoi.model.Product;
import com.example.ketnoi.repository.ProductRepository;
import com.example.ketnoi.service.CategoryService;
import com.example.ketnoi.service.ProductServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductServie productServie;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("product")
    public ResponseEntity<List<Product>>showListproduct() {
        List<Product> productList = productServie.getAll();
        if (productList.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>( productList,HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> showListCategory() {
        List<Category> categoryList = categoryService.getAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
    }

}