package com.example.shop.controllers;

import com.example.shop.errors.ProductNotFoundException;
import com.example.shop.loger.ToLog;
import com.example.shop.model.Product;
import com.example.shop.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController  {


    private ProductService service ;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/v1/product/{id}")
    @ResponseBody
    @ToLog
     public ResponseEntity<Product> getProductById(@PathVariable Long id) throws ProductNotFoundException {
        Product p = service.findById(id);
        if(p==null){
            throw new ProductNotFoundException();
        }
              return  ResponseEntity.
                      status(HttpStatus.OK)
                      .header("Product", p.getTitle())
                      .body(p);
    }

    @GetMapping("/v1/product/all")
    @ResponseBody
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = service.findAll();
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(products);
    }


    @PostMapping("/v1/product/{product}")// уточнить как передать обект по http в базу и уточнить что использовать для сохранения обьектов POST или не POST
    @ResponseBody
    @ToLog
    public ResponseEntity<Product> saveNewProductByDB(@PathVariable Product product){
        service.save(product);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(product);

    }


    @DeleteMapping("/v1/product/del/{id}")
    @ResponseBody
    @ToLog
    public  ResponseEntity<String> deleteProductById(@PathVariable Long id) throws ProductNotFoundException {
       service.deletById(id);
       String message = "Product delete";
        return  ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(message);
    }

    @GetMapping("/v2/product")
    public String findProductById(Model model) {

        return "product_page";
    }


}
