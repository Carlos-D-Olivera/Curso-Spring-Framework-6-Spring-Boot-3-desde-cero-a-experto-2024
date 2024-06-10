package com.cdog.springboot.di.app.SpringBoot_di.services;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;
import com.cdog.springboot.di.app.SpringBoot_di.repositories.ProductRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    @Override
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

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

    @Override
    public List<Product> findByName(String name){
        return repository.searchByName(name);
    }

}
