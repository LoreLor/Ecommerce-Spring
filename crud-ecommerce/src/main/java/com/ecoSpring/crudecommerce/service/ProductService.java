package com.ecoSpring.crudecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecoSpring.crudecommerce.model.Product;

public interface ProductService {
    public List<Product> findAll();
    public Product save(Product producto);
    public Optional<Product> get(Integer id);
    public void update(Product producto);
    public void delete(Integer id);
}
