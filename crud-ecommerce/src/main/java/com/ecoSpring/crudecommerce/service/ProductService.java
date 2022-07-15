package com.ecoSpring.crudecommerce.service;

import java.util.Optional;

import com.ecoSpring.crudecommerce.model.Product;

public interface ProductService {
    public Product save(Product producto);
    public Optional<Product> get(Integer id);
    public void update(Product producto);
    public void delete(Integer id);
}
