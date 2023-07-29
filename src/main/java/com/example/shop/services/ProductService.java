package com.example.shop.services;


import com.example.shop.errors.ProductNotFoundException;
import com.example.shop.model.Product;


import java.util.List;

public interface ProductService {

    Product findById(Long id) throws ProductNotFoundException;
    List<Product> findAll();
    void save(Product p);
    void deletById(Long id);
}
