package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    IProductService iProductService = new ProductService();

    @GetMapping("/")
    public ModelAndView showList() {
        return new ModelAndView("index", "products", iProductService.findAll());
    }

    @GetMapping("/product/create")
    public ModelAndView showCreate() {
        return new ModelAndView("create", "product", new Product());
    }

    @GetMapping("/product/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id) {
        return new ModelAndView("edit", "product", iProductService.findById(id));
    }

    @GetMapping("/product/{id}/delete")
    public ModelAndView showDelete(@PathVariable int id) {
        return new ModelAndView("delete", "product", iProductService.findById(id));
    }

    @GetMapping("/product/{id}/view")
    public ModelAndView showView(@PathVariable int id) {
        return new ModelAndView("view", "product", iProductService.findById(id));
    }

    @PostMapping("/product/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) Math.random() * 1000);
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("success", "Saved product successfully!");
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/update";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/delete";
    }
}

