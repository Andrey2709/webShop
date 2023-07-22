package com.example.shop.services;


import com.example.shop.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Scope
public class CartService {
    private List<Product> listProduct;


    public List<Product> show(){
        return listProduct;
    }
}
