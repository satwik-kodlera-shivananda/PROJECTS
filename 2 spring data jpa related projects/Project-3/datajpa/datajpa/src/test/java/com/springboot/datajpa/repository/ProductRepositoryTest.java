package com.springboot.datajpa.repository;

import com.springboot.datajpa.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepositoryTest {


    @Autowired
    private ProductRepository productRepository;
    @Test
    public void saveProductMethod(){

        Product product = new Product();
        product.setName("TV");

        productRepository.save(product);

    }
}
