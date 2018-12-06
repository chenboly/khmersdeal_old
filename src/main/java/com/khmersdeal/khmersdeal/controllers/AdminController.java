package com.khmersdeal.khmersdeal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping(value={"/","/home","/admin","/index"})
    public String adminPage(){
        return "admin/index";
    }
}
