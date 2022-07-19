package com.ecoSpring.crudecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecoSpring.crudecommerce.model.Product;
import com.ecoSpring.crudecommerce.service.ProductService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String home(Model model){
        List<Product> producto = productService.findAll();
        model.addAttribute("producto", producto);
        return "admin/home";
    }
    
}
