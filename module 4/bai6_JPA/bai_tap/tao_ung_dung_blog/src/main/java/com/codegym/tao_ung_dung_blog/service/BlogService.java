package com.codegym.tao_ung_dung_blog.service;

import com.codegym.tao_ung_dung_blog.model.Blog;
import com.codegym.tao_ung_dung_blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    public Blog findBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

}