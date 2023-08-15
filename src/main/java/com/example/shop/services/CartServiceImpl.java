package com.example.shop.services;


import com.example.shop.errors.ProductNotFoundException;
import com.example.shop.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartServiceImpl implements CartService {
    private List<Product> listProduct ;
    private ProductService service;

    public CartServiceImpl(List<Product> listProduct, ProductService service) {
        this.listProduct = listProduct;
        this.service = service;
    }

    public List<Product> show() {
        return listProduct;
    }

    public List<Product> getAllProducts() {
        return listProduct;
    }

    @Override
    public List<Product> addProduct(Long id) throws ProductNotFoundException {
        listProduct.add(service.findById(id));
        return listProduct;

    }

    @Override
    public List<Product> removeProduct(Long id) {
        StringBuilder bilder = new StringBuilder();
        for (int i = 0; i <= bilder.length() ; i++) {
            if(bilder.charAt(i)==','){
                bilder.deleteCharAt(i);
                bilder.insert(i," and");
            }
        }
bilder.toString();


        listProduct.removeIf(product -> product.getId()==id);
      return listProduct;
    }
}
