package com.shop.controller;

import com.shop.model.Category;
import com.shop.model.ProductBrand;
import com.shop.service.ProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {
    @Autowired
    private ProductBrandService productBrandService;

    //    @RequestMapping()
//    public ModelAndView getListCategory(@PageableDefault(size = 4) Pageable pageable, @RequestParam("search") Optional<String> search, Mode model){
//        Page<Category> categories;
//        if (search.isPresent()) {
//            categories = categoryService.findCategoryByNameContaining(search.get(),pageable);
//        } else {
//            categories = categoryService.findAll(pageable);
//        }
//        return new ModelAndView("admin/category/list", "categories", categories);
//    }
    @GetMapping()
    public ModelAndView getBrandList(@PageableDefault(size = 4) Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<ProductBrand> productBrands;
        if (search.isPresent()) {
            productBrands = productBrandService.findProductBrandByNameContaining(search.get(), pageable);
        } else {
            productBrands = productBrandService.findAll(pageable);
        }
        return new ModelAndView("Admin/brand/list", "productBrands", productBrands);
    }

    @GetMapping("create")
    public ModelAndView getCreatePage(Model model) {
        List<ProductBrand> productBrands = productBrandService.findAll();
        model.addAttribute("productBrands", productBrands);
        return new ModelAndView("Admin/brand/create", "productBrands", new Category());
    }

    @PostMapping("create")
    public String saveProductBrand(@ModelAttribute("productBrands") ProductBrand productBrand) {
        productBrandService.saveProductBrand(productBrand);
        return "redirect:/admin/brand";
    }

    @GetMapping("edit-productBrand/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<ProductBrand> productBrands = productBrandService.findProductBrandById(id);
        if (productBrands != null) {
            return new ModelAndView("/Admin/brand/edit", "productBrands", productBrands);
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit-productBrand")
    public ModelAndView updateProductBrand(@ModelAttribute("productBrands") ProductBrand productBrand) {
        return new ModelAndView("redirect:/admin/brand");
    }

    @GetMapping("/delete-productBrand/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        productBrandService.deleteProductBrand(id);
        return new ModelAndView("redirect:/admin/brand");
    }
}

//        @PostMapping("/delete-productBrand")
//        public ModelAndView DeleteProductBrand(@ModelAttribute("productBrands") ProductBrand productBrand) {
//            productBrandService.deleteProductBrand(getId());
//            return new ModelAndView("redirect:/admin/brand");
//        }
//
//    }
