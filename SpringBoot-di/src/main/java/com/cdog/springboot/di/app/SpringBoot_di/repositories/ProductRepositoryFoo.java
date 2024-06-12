package com.cdog.springboot.di.app.SpringBoot_di.repositories;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;

import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;



@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monito Azus 27",600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monito Azus 27",600L);
    }

    @Override
    public List<Product> searchByName(String name) {
        return Collections.singletonList(new Product(1L, name,600L));
    }
}
