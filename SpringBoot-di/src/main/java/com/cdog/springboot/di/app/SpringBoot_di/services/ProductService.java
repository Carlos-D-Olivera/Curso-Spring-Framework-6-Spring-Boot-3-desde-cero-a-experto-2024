package com.cdog.springboot.di.app.SpringBoot_di.services;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;
import com.cdog.springboot.di.app.SpringBoot_di.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll(){
        return repository.findAll().stream().map(
                p -> {
                    Double taxePrice = p.getPrice()*1.25d;
                    //Product newProduct = new Product(p.getId(), p.getName(), taxePrice.longValue()); //Principio de inmutabilidad: se crea un nuevo objeto para no alterar el producto original
                    Product newProduct = (Product) p.clone();
                    newProduct.setPrice(taxePrice.longValue());
                    return newProduct;
                }
                ).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }

    public List<Product> findByName(String name){
        return repository.findByName(name);
    }

}
