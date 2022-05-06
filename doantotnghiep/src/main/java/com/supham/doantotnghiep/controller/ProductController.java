package com.supham.doantotnghiep.controller;

import com.supham.doantotnghiep.model.Product;
import com.supham.doantotnghiep.service.ProductBrandService;
import com.supham.doantotnghiep.service.ProductService;
import com.supham.doantotnghiep.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("home/")
public class ProductController {
        @Autowired
        private ProductService productService;
        @Autowired
        private ProductBrandService productBrandService;
        @Autowired
        private ProductTypeService productTypeService;

        @GetMapping("")
        public ModelAndView getHome() {
            return new ModelAndView("home");
        }

        @GetMapping("product")
        public ModelAndView getCustomerList(@PageableDefault(size = 4) Pageable pageable, @RequestParam("search") Optional<String> search) {
            Page<Product> products;
            if (search.isPresent()) {
                products = productService.findAllByNameContaining(search.get(), pageable);
            } else {
                products = productService.findAll(pageable);
            }
            return new ModelAndView("Product/list", "products", products);
        }
}
