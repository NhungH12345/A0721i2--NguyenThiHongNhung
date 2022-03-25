package com.codegym.quan_ly_dien_thoai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmartPhoneController {
    @GetMapping("/")
    public String showIndex() {
        return "/index";
    }
}
