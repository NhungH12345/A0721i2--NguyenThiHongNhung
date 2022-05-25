package com.example.ketnoi.service;

import com.example.ketnoi.model.Category;
import com.example.ketnoi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }


}
