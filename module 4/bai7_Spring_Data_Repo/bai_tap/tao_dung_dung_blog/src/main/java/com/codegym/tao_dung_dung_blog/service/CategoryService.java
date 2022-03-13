package com.codegym.tao_dung_dung_blog.service;

import com.codegym.tao_dung_dung_blog.model.Category;
import com.codegym.tao_dung_dung_blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public  Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
