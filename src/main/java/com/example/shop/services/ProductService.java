package com.example.shop.services;


import com.example.shop.errors.ProductNotFoundException;
import com.example.shop.model.Product;
import com.example.shop.model.ProductDto;


import java.util.List;

public interface ProductService {

    ProductDto findById(Long id) throws ProductNotFoundException;
    List<ProductDto> findAll();
    void save(Product p);
    void deletById(Long id);
}
