package com.cdog.springboot.di.app.SpringBoot_di.repositories;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Hot dog", 5000L),
            new Product(2L, "CPU Intel Core i9",850000L),
            new Product(3L, "Teclado Razer mini 60%", 180000L),
            new Product(4L, "Motherboard Gigabyte",490000L)
        );
    }

    public List<Product> findAll(){
        return this.data;
    }

    public Product findById(Long id){
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
