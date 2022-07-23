package com.ecoSpring.crudecommerce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecoSpring.crudecommerce.model.Product;
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
        public String productohome(@PathVariable Integer id, Model model){
            Product producto = new Product();
            Optional<Product> optionalProduct = productService.get(id); //como lista
            producto = optionalProduct.get();
            
            LOGGER.info("Producto buscado: {}", producto);
            model.addAttribute("producto", producto); //nomdre de vista , valor de avariable
            
            return "usuario/productohome";
        
    }
}
