package com.example.shop.services;



import com.example.shop.loger.ToLog;
import com.example.shop.model.Product;
import com.example.shop.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class ProductServiceImpl implements ProductService {
    private Logger logger = Logger.getLogger(ProductService.class.getName());

    private final ProductRepository repo;




    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @ToLog
    public Product findById(Long id) {
        Optional<Product> p = repo.findById(id);
        Product product = p.get();

        return product;
    }


    public List<Product> findAll() {
       return repo.findAll();

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
