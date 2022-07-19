package com.ecoSpring.crudecommerce.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecoSpring.crudecommerce.model.Product;
import com.ecoSpring.crudecommerce.model.Usuario;
import com.ecoSpring.crudecommerce.service.ProductService;
import com.ecoSpring.crudecommerce.service.UploadFileService;



@Controller
@RequestMapping("/products")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    /*para acceder a los metodos */
    @Autowired
    private ProductService productService; 

    @Autowired
    private UploadFileService upload;
    
    /*aca mapea a productos */
    @GetMapping("")  
    public String show(Model model) {
        model.addAttribute("producto", productService.findAll());
        return "products/show";
    };

    /*para q me dirija a creacion de producto */
    @GetMapping(value="/create")  
    public String create(){
        return "products/create";
    };


    @PostMapping(value="/save")
    public String save(Product producto, @RequestParam("img") MultipartFile file) throws IOException{

        LOGGER.info("Este es el objeto producto {}",producto);

        /*para que me tome el usuario admin */
        Usuario user= new Usuario(1,"","","","","","", "");
        producto.setUsuario(user);

        //image
        //cuando se crea el producto
        if(producto.getId()==null){  
            String imageName = upload.saveImage(file);
            producto.setImage(imageName);
          
        }else{
           
        }

        productService.save(producto);
        return "redirect:/products";
    };


    @GetMapping(value="/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Product producto = new Product();
        Optional<Product> optionalProduct = productService.get(id);
        producto = optionalProduct.get();

        LOGGER.info("Producto buscado: {}", producto);
        model.addAttribute("producto", producto);

        return "products/edit";
    };


    @PostMapping(value="/update")
    public String update(Product producto,  @RequestParam("img") MultipartFile file) throws IOException{
        Product p = new Product();
        p = productService.get(producto.getId()).get();

         //se edita el producto pero no se cambia la imagen
        if(file.isEmpty()){              
            producto.setImage(p.getImage());

        //se edita tambien la imagen
        }else{  

        //elimina imagen del servidor si no es la de por defecto
            if(!p.getImage().equals("default.jpg")){ 
                upload.deleteImage(p.getImage());
            }

            String imageName = upload.saveImage(file);
            producto.setImage(imageName);
        }
        
        producto.setUsuario(p.getUsuario());
        productService.update(producto);
        return "redirect:/products";
    };



    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Product p= new Product();
        p = productService.get(id).get();

        //elimina imagen del servidor si no es la de por defecto
        if(!p.getImage().equals("default.jpg")){  
            upload.deleteImage(p.getImage());
        }

        productService.delete(id);
        return "redirect:/products";
    }
}
