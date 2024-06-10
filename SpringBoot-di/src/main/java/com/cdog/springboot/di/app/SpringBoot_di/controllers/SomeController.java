package com.cdog.springboot.di.app.SpringBoot_di.controllers;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;
import com.cdog.springboot.di.app.SpringBoot_di.services.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductServiceImpl productService = new ProductServiceImpl();
    @GetMapping()
    public List<Product> lists(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam(name = "nombre") String name){
        return productService.findByName(name);
    }
}
