package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.*;
import com.codegym.casestudy.service.RentTypeService;
import com.codegym.casestudy.service.ServiceService;
import com.codegym.casestudy.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ServiceController {
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("services")
    public ModelAndView listService(@PageableDefault(size = 3) Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<Service> services;
        if (search.isPresent()) {
            services = serviceService.findAllByNameContaining(search.get(), pageable);
        } else {
            services = serviceService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("service/list");
        modelAndView.addObject("services", services);
        return modelAndView;
    }
    @GetMapping("/create_service")
    public ModelAndView getCreate(Model model) {
        List<ServiceType> serviceTypes = serviceTypeService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        model.addAttribute("serviceTypes", serviceTypes);
        model.addAttribute("rentTypes", rentTypes);
        return new ModelAndView("service/create", "service", new Service());
    }

    @PostMapping("/create_service")
    public String saveService(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
        serviceService.saveService(service);
        redirectAttributes.addFlashAttribute("message", "Create service success");
        return "redirect:/services";
    }
    @GetMapping("/edit-service/{id}")
    public ModelAndView showEditForm(@PathVariable int id, Model model) {
        List<ServiceType> serviceTypes= serviceTypeService.findAll();
        List<RentType> rentTypes= rentTypeService.findAll();

        Optional<Service> service = serviceService.findServiceById(id);
        if (service != null) {
            model.addAttribute("serviceTypes", serviceTypes);
            model.addAttribute("rentTypes", rentTypes);
            ModelAndView modelAndView = new ModelAndView("service/edit");
            modelAndView.addObject("service", service);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("/edit-service")
    public ModelAndView updateService(@ModelAttribute("service") Service service) {
        serviceService.saveService(service);
        ModelAndView modelAndView = new ModelAndView("service/edit");
        modelAndView.addObject("service", service);
        modelAndView.addObject("message", "Service updated successfully");
        return new ModelAndView("redirect:/services");
    }
    @GetMapping("/delete-service/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id, Model model) {
        List<ServiceType> serviceTypes= serviceTypeService.findAll();
        List<RentType> rentTypes= rentTypeService.findAll();
        model.addAttribute("serviceTypes", serviceTypes);
        Optional<Service> service = serviceService.findServiceById(id);
        if (service != null) {
            model.addAttribute("serviceTypes", serviceTypes);
            model.addAttribute("rentTypes", rentTypes);
            ModelAndView modelAndView = new ModelAndView("service/delete");
            modelAndView.addObject("service", service);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }

    @PostMapping("/delete-service")
    public ModelAndView deleteCustomer(@ModelAttribute("service") Service service, int id) {
        serviceService.deleteService(id);
        return new ModelAndView("redirect:/services");
    }

}
