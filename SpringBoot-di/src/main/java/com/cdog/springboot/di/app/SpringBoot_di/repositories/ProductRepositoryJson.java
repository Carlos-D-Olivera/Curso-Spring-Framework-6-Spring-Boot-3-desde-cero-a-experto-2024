package com.cdog.springboot.di.app.SpringBoot_di.repositories;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;

    public ProductRepositoryJson(){
        ClassPathResource resource = new ClassPathResource("json/product.json"); //Obtenemos el archivo Json
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class)); //Leemos los valores del archivo y lo convertimos a una lista de Productos
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p->p.getId().equals(id)).findFirst().orElse(new Product(0L, "Producto no encontrado", 0L));
    }

    @Override
    public List<Product> searchByName(String name) {
        return list.stream().filter(p->p.getName().contains(name)).collect(Collectors.toList());
    }
}
