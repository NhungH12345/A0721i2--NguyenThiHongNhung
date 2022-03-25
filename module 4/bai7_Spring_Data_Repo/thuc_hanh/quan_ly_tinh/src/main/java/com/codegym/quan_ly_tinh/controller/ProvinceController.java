package com.codegym.quan_ly_tinh.controller;

import com.codegym.quan_ly_tinh.model.Provinces;
import com.codegym.quan_ly_tinh.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/provinces")
    public ModelAndView listProvinces() {
        Iterable<Provinces> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create-province")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Provinces());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveProvince(@ModelAttribute("province") Provinces province) {
        provinceService.save(province);

        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Provinces());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Provinces> province = provinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province", province.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }

    @PostMapping("/edit-province")
    public ModelAndView updateProvince(@ModelAttribute("province") Provinces province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Provinces> province = provinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/province/delete");
            modelAndView.addObject("province", province.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }

    @PostMapping("/delete-province")
    public String deleteProvince(@ModelAttribute("province") Provinces province) {
        provinceService.remove(province.getId());
        return "redirect:provinces";
    }
}
