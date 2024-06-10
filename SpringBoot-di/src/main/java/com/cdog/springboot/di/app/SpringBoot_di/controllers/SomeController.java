package com.cdog.springboot.di.app.SpringBoot_di.controllers;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;
import com.cdog.springboot.di.app.SpringBoot_di.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired //Lo inyectamos ya que el ProductServiceImpl esta anotado con @Component
    //private ProductServiceImpl productService  /*= new ProductServiceImpl()*/;
    private ProductService productService; //Ya no inyectamos la implementacion si no la interfaz. Spring se encargara de buscar el componente que la este implementando.

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
