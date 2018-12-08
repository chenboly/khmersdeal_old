package com.khmersdeal.khmersdeal.controllers;

import com.khmersdeal.khmersdeal.models.ProductDTO;
import com.khmersdeal.khmersdeal.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    private ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value={"/","/home","/admin","/index"})
    public String adminPage(){
        return "admin/index";
    }

    @GetMapping("/dashboard1")
    public String getDashboard1(Model model){
        List<ProductDTO> productDTOList = productService.getAllProduct();
        model.addAttribute("productList", productDTOList);
        return "admin/dashboard :: dashboard1";
    }

//    @GetMapping("/dashboard2")
//    public String getDashboard2(){
//        return "admin/dashboard :: dashboard2";
//    }
}
