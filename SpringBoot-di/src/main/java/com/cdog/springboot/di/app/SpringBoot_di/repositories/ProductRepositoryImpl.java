package com.cdog.springboot.di.app.SpringBoot_di.repositories;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;
//import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Primary //Se usa para indicar que esta va a ser la implematacion de ProductRepository que se va a usar
//@Component
@Repository //Se cambia el @Component por @Repository
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Hot dog", 5000L),
            new Product(2L, "CPU Intel Core i9",850000L),
            new Product(3L, "Teclado Razer mini 60%", 180000L),
            new Product(4L, "Motherboard Gigabyte",490000L),
            new Product(5L, "Dog food 200g", 15000L)
        );
    }

    @Override
    public List<Product> findAll(){
        return this.data;
    }

    @Override
    public Product findById(Long id){
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Product> searchByName(String name){
        return this.data.stream().filter(
                p -> p.getName().toUpperCase().
                    contains(name.toUpperCase()))
                .collect(Collectors.toList());
    }
}
