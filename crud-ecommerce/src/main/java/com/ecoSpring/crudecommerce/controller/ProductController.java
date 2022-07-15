package com.ecoSpring.crudecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    @GetMapping("")   /*aca mapea a productos */
    public String show() {
        return "products/show";
    }
    
}
