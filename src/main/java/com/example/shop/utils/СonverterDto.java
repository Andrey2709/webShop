package com.example.shop.utils;


import com.example.shop.model.Product;
import com.example.shop.model.ProductDto;


public class СonverterDto {


    public ProductDto convertToDto(Product product){
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }

    public  Product convertToProduct(ProductDto dto){
        return new Product(dto.getId(), dto.getTitle(), dto.getPrice());
    }

}
