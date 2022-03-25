package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

   // @GetMapping("customers")
//    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable) {
//        Page<Customer> customers;
//        if (search.isPresent()) {
//            customers = customerService.searchCustomer_Name(search.get(), pageable);
//        } else {
//            customers = customerService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("Customer/list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
    @GetMapping("customers")
    public ModelAndView getCustomerList(@RequestParam(name = "nameCus", required = false,defaultValue = "") String name, @PageableDefault(size = 2) @SortDefault(value = "name", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Customer> customers = customerService.searchByName(name, pageable);
        ModelAndView modelAndView = new ModelAndView("Customer/list");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("nameCus",name);
        return modelAndView;
    }
    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("Customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("Customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "Created customer successfully");
        return modelAndView;
    }
}
