package com.codegym.casestudy.controller;


import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.service.CustomerService;
import com.codegym.casestudy.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("home")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;
    @GetMapping
    public ModelAndView GetHomePage(){
        return new ModelAndView("home");
    }

    @GetMapping("customers")
    public ModelAndView listCustomers(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<Customer> customers;
        if (search.isPresent()) {
            customers = customerService.findAllByNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView getCreatePage(Model model) {
        List<CustomerType> customerTypes= customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        return new ModelAndView("customer/create", "customer", new Customer());
    }

    @PostMapping("create")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "Create customer success");
        return new ModelAndView("redirect:/customers");
    }
    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id, Model model) {
        List<CustomerType> customerTypes= customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id, Model model) {
        List<CustomerType> customerTypes= customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("customer/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public ModelAndView deleteCustomer(@ModelAttribute("customer") Customer customer, long id) {
        customerService.deleteCustomer(id);
        return new ModelAndView("redirect:/customers");
    }

//
//    @PostMapping("create")
//    public String saveCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//        if (bindingResult.hasFieldErrors()) {
//            List<Customer> customerTypes = customerTypeService.findAll();
//            model.addAttribute("customerTypes", customerTypes);
//            //  model.addAttribute("customer", new Customer());
//            return "create";
//        } else {
//            customerService.saveCustomer(customer);
//            redirectAttributes.addFlashAttribute("message", "Create success");
//            return "redirect:/";
//        }
    }
