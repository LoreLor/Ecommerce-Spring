package com.ecoSpring.crudecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecoSpring.crudecommerce.model.Order;
import com.ecoSpring.crudecommerce.model.OrderDetail;
import com.ecoSpring.crudecommerce.model.Product;
import com.ecoSpring.crudecommerce.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger LOGGER= LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductService productService;


    /* Para almacenar detalles de la compra */
    List<OrderDetail> cart= new ArrayList<OrderDetail>();

    /* Almacena la orden de compra */
    Order order = new Order();


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

    @PostMapping("/cart")
    public String addCart(@RequestParam Integer id, @RequestParam Integer qty, Model model){
        OrderDetail orderDetail = new OrderDetail();
        Product producto = new Product();
        double sumTotal = 0; 

        /*Busoc el producto */
        Optional <Product> optionalProduct = productService.get(id);
        LOGGER.info("CartProduct: {}", optionalProduct.get());
        LOGGER.info("Qty: {}", qty);
       
        producto = optionalProduct.get();

        /*me seteo traigo los datos del producto */
        orderDetail.setQty(qty);
        orderDetail.setPrice(producto.getPrice());
        orderDetail.setName(producto.getName());
        orderDetail.setTotal(producto.getPrice()*qty);
        orderDetail.setProducto(producto);

        /*Validacion de existencia de item en cart p/evitar duplicados */
        Integer idProducto = producto.getId();
        boolean existeProducto = cart.stream().anyMatch(item -> item.getProducto().getId() == idProducto); /*es como un for pero con caracteristica de java8 */

        if(!existeProducto){
            cart.add(orderDetail);
        }


        /*ahora tengo que sumar los totales */
        sumTotal = cart.stream().mapToDouble(dt->dt.getTotal()).sum();

        /*Para agregar a la lista */

        order.setTotal(sumTotal);
        model.addAttribute("cart", cart);
        model.addAttribute("order", order);

        return "usuario/carrito";
    }

    @GetMapping("delete/cart/{id}")
    public String deleteProductCart(@PathVariable Integer id, Model model){
        /* lista nueva de productos */
        List <OrderDetail> newOrderDetail = new ArrayList<OrderDetail>();

        /*es lo que va a recorrer */
        for(OrderDetail orderDetail: cart)
        if(orderDetail.getProducto().getId() != id){
            newOrderDetail.add(orderDetail);
        }

        /*lista filtrada con eliminacion del id seleccionado */
        cart = newOrderDetail;

        /*ahora tengo que sumar los totales nuevos para actualizar*/
        double sumTotal = 0;
        sumTotal = cart.stream().mapToDouble(dt->dt.getTotal()).sum();

        order.setTotal(sumTotal);
        model.addAttribute("cart", cart);
        model.addAttribute("order", order);

        return "usuario/carrito";   /*me lleva al directorio del archivo de la vista del carro una vez q se elimina el producto*/
    }

    @GetMapping("/getCart")
    public String getCart(Model model){
        model.addAttribute("cart", cart);
        model.addAttribute("order", order);
        return "/usuario/carrito";
    }
}
