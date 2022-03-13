package com.codegym.tao_dung_dung_blog.service;

import com.codegym.tao_dung_dung_blog.model.Blog;
import com.codegym.tao_dung_dung_blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(org.springframework.data.domain.Pageable.unpaged());
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
    public Page<Blog> searchByTitle(String title , Pageable pageable) {
        return blogRepository.searchByTitle(title, (org.springframework.data.domain.Pageable) pageable);
    }

}