package com.codegym.tao_dung_dung_blog.controller;

import com.codegym.tao_dung_dung_blog.model.Blog;
import com.codegym.tao_dung_dung_blog.model.Category;
import com.codegym.tao_dung_dung_blog.service.BlogService;
import com.codegym.tao_dung_dung_blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Controller

public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("customers")
    public ModelAndView listBlog(@RequestParam("search") Optional<String> search, org.springframework.data.domain.Pageable pageable) {
        Page<Blog> blogs;
        if (search.isPresent()) {
            blogs = blogService.searchByTitle(search.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create-blog")

    public ModelAndView getCreatePage(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("category", categories);
        return new ModelAndView("blog/create", "blog", new Blog());
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.saveBlog(blog);
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("blog/message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editBlog(@PathVariable long id) {
        return new ModelAndView("blog/edit", "blog", blogService.findBlogById(id));
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.saveBlog(blog);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }
}