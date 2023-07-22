package com.example.shop.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Scope()
public class Cart {

    private List<Product> productCart;

    public Cart(List<Product> productCart) {
        this.productCart = productCart;
    }

    public List<Product> getProductCart() {
        return productCart;
    }

    public void setProductCart(List<Product> productCart) {
        this.productCart = productCart;
    }
}
