package com.cdog.springboot.di.app.SpringBoot_di.controllers;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;
import com.cdog.springboot.di.app.SpringBoot_di.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cart")
@RestController
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @PostMapping("/add")
    public List<Object> agregarDentroCarrito(@RequestBody() Product product){
        carritoService.agregarItem(product);
        return mostrarListaCarrito();
    }

    @GetMapping("/list")
    public List<Object> mostrarListaCarrito(){
        return carritoService.listarItems();
    }

    @DeleteMapping("/delete/{id}")
    public List<Object> borrarProducto(@PathVariable Long id){

        carritoService.eliminarItem(id);

        return carritoService.listarItems();
    }

}
