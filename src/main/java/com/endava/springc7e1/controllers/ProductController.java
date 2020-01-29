package com.endava.springc7e1.controllers;

import com.endava.springc7e1.entities.Product;
import com.endava.springc7e1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public List<Product> findAll() {
         return productRepository.findAll();
    }

}
