package com.example.shop.services;



import com.example.shop.loger.ToLog;
import com.example.shop.model.Product;
import com.example.shop.model.ProductDto;
import com.example.shop.repository.ProductRepository;
import com.example.shop.utils.СonverterDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {
    private Logger logger = Logger.getLogger(ProductService.class.getName());

    private final ProductRepository repo;
    private final СonverterDto converter = new СonverterDto();


    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @ToLog
    public ProductDto findById(Long id) {
        Optional<Product> p = repo.findById(id);
        Product product = p.get();
        ProductDto dto = converter.convertToDto(product);
        return dto;
    }


    public List<ProductDto> findAll() {
        List<Product> listProduct = repo.findAll();
        return listProduct.stream().map(product -> {
            ProductDto dto = converter.convertToDto(product);
            return dto;
        }).collect(Collectors.toList());
    }

    @ToLog
    public void save(Product product) {
        repo.save(product);
    }


    @ToLog
    public void deletById(Long id) {
        repo.deleteById(id);
    }

    //    public Product findByName(String name) {
//        Optional<Product> p = repo.findByName(name);
//        Product product = p.get();
//        return product;
//    }

}
