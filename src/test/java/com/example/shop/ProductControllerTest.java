package com.example.shop;

import com.example.shop.controllers.ProductController;
import com.example.shop.errors.ProductNotFoundException;
import com.example.shop.model.Product;
import com.example.shop.repository.ProductRepository;
import com.example.shop.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

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
        var apple = new Product(1L, "Apple", 50);
        doReturn(apple).when(this.service).findById(1l);
        //when
        var responseEntity = this.productController.getProductById(1l);

        //then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(apple, responseEntity.getBody());

    }

    @Test
    @DisplayName("GET/shop/v2/product/all")
    public void getAllProduct_ReturnsValidResponseEntity() throws ProductNotFoundException {
        //given
        var products = List.of(new Product(1l, "apple", 50), new Product(2l, "Milk", 100)
                , new Product(3l, "Eggs", 120)
                , new Product(4l, "Milkshake", 160)
                , new Product(5l, "Bread", 50));
        doReturn(products).when(this.service).findAll();
        //when
        var responseEntity = this.productController.getAllProduct();

        //then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(products, responseEntity.getBody());

    }

    @Test
    @DisplayName("POST/shop/v2/product/{product}")
    public void createNewProduct_ReturnsValidResponseEntity() throws ProductNotFoundException {
        //given
       Product p  = new Product(-1l,"juice", 15);
        //when
        var responseEntity = this.productController.saveNewProductByDB(p);

        //then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(responseEntity.getBody(),p);

        verify(this.service).save(p);
    }

    @Test
    @DisplayName("DELETE/shop/v2/product/{product}")
    public void deleteProduct_ReturnsValidResponseEntity() throws ProductNotFoundException {
    //given

        long id = 1l;
    //when
        var responseEntity = this.productController.deleteProductById(id);
    // then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(responseEntity.getBody() , "Product delete");
        assertEquals(this.service.findById(id), null);
        verify(this.service).deletById(id);


    }

}
