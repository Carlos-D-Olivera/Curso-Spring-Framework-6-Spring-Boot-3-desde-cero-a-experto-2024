package com.cdog.springboot.di.app.SpringBoot_di.repositories;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;

import java.util.List;

public interface ProductRepository{
    List<Product> findAll();

    Product findById(Long id);

    List<Product> searchByName(String name);
}
