package com.example.shop;

import com.example.shop.controllers.ProductController;
import com.example.shop.errors.ProductNotFoundException;
import com.example.shop.model.ProductDto;
import com.example.shop.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    ProductService service;
    @InjectMocks
    ProductController productController;

    @Test
    @DisplayName("GET/shop/v2/product/{id}")
    public void getProductById_ReturnsValidResponseEntity() throws ProductNotFoundException {
        //given
        var apple = new ProductDto(1L, "Apple", 50);
        doReturn(apple).when(this.service).findById(1l);
        //when
        var responseEntity = this.productController.getProductById(1l);

        //then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(apple,responseEntity.getBody());


    }

}
