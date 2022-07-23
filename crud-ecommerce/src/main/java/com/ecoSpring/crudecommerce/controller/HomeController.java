package com.ecoSpring.crudecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecoSpring.crudecommerce.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger LOGGER= LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String home(Model model){
        model.addAttribute("producto", productService.findAll());
        return "usuario/home";
    }
    
    @GetMapping("/producto/{id}")
        public String productohome(@PathVariable Integer id){

            LOGGER.info("id del producto enviado como parametro {}", id);

            return "usuario/productohome";
        
    }
}
