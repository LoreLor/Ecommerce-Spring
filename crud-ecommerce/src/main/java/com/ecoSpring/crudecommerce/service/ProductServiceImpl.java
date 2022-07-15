package com.ecoSpring.crudecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoSpring.crudecommerce.model.Product;
import com.ecoSpring.crudecommerce.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product producto) {
        return productRepository.save(producto);
    }

    @Override
    public Optional<Product> get(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product producto) {
        productRepository.save(producto);    
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);  
    }
    
}
