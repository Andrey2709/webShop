package com.example.shop.controllers;

import com.example.shop.errors.ProductNotFoundException;
import com.example.shop.model.Product;
import com.example.shop.model.ProductDto;
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
     public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) throws ProductNotFoundException {
        ProductDto p = service.findById(id);
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
    public List<ProductDto> getAllProduct(){
        return service.findAll();
    }


    @PostMapping("/v1/product/{id}")
    @ResponseBody
    public ResponseEntity<Product> saveNewProduct(@PathVariable Product product){
        service.save(product);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(product);

    }


    @DeleteMapping("/v1/product/del/{id}")
    @ResponseBody
    public  ResponseEntity<String> deleteById(@PathVariable Long id) throws ProductNotFoundException {
       service.deletById(id);
       String message = "Product delete";
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(message);
    }

    @GetMapping("/v2/product")
    public String findProductById(Model model) {

        return "product_page";
    }


}
