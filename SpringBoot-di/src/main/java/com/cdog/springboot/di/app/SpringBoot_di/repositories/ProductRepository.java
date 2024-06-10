package com.cdog.springboot.di.app.SpringBoot_di.repositories;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Hot dog", 5000L),
            new Product(2L, "CPU Intel Core i9",850000L),
            new Product(3L, "Teclado Razer mini 60%", 180000L),
            new Product(4L, "Motherboard Gigabyte",490000L),
            new Product(5L, "Dog food 200g", 15000L)
        );
    }

    public List<Product> findAll(){
        return this.data;
    }

    public Product findById(Long id){
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Product> findByName(String name){
        return this.data.stream().filter(
                p -> p.getName().toUpperCase().
                    contains(name.toUpperCase()))
                .collect(Collectors.toList());
    }
}
