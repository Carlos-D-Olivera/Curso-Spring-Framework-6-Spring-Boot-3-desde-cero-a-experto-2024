package com.cdog.springboot.di.app.SpringBoot_di.services;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);

    List<Product> findByName(String name);
}
