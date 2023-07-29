package com.example.shop.controllers;


import com.example.shop.errors.ProductNotFoundException;
import com.example.shop.loger.ToLog;
import com.example.shop.model.Product;
import com.example.shop.services.CartService;
import com.example.shop.services.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService service;
//   GET/v2/cart      получить карзину
//    GET/v2/cart/put/product/{id}
//    GET/v2/cart/del/product/{id}

    @GetMapping("/cart/show")
    @ToLog
    public List<Product> findAllProductInCart() {
        return service.getAllProducts();

    }


    @GetMapping("/cart/add/{id}")
    @ToLog
    public List<Product> addProductToCart(@PathVariable Long id) throws ProductNotFoundException {
        service.addProduct(id);
        return service.getAllProducts();
    }

    @GetMapping("/cart/remove/{id}")
    @ToLog
    public List<Product> removeProductToCart(@PathVariable Long id) throws ProductNotFoundException {
        service.removeProduct(id);
        return service.getAllProducts();
    }



}
