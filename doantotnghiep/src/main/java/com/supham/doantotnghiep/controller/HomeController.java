package com.supham.doantotnghiep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping
    public String GetHomePage(){
        return "home";
    }
}
