package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @GetMapping("/sandwich")
    public String showSandwichSpice() {
        return "index";
    }

    @PostMapping("/save")
    public ModelAndView Condiment(@RequestParam("condiment") String[] condiment) {
        if(condiment[0]=="null") {
            System.out.println("123");
        }
        return new ModelAndView("condiment", "condiment", condiment);
    }
}
