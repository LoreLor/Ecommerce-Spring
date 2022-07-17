package com.ecoSpring.crudecommerce.controller;

import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecoSpring.crudecommerce.model.Product;
import com.ecoSpring.crudecommerce.model.Usuario;
import com.ecoSpring.crudecommerce.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService; /*para acceder a los metodos */
    
    @GetMapping("")   /*aca mapea a productos */
    public String show(Model model) {
        model.addAttribute("producto", productService.findAll());
        return "products/show";
    }
    
    @GetMapping("/create")  /*para q me dirija a creacion de producto */
    public String create(){
        return "products/create";
    }

    @PostMapping("/save")
    public String save(Product producto){
        LOGGER.info("Este es el objeto producto {}",producto);
/*para que me tome el usuario admin */
        Usuario user= new Usuario(1,"","","","","","", "");
        producto.setUsuario(user);

        productService.save(producto);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Product producto = new Product();
        Optional<Product> optionalProduct = productService.get(id);
        producto = optionalProduct.get();

        LOGGER.info("Producto buscado: {}", producto);
        model.addAttribute("producto", producto);

        return "products/edit";
    }

    @PostMapping("/update")
    public String update(Product producto){
        productService.update(producto);
        return "redirect:/products";
    }

}
