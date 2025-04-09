package com.cdog.springboot.di.app.SpringBoot_di.services;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SessionScope //El carrito sera individual por cada sesion
@Primary
@Service("carritoCompras")
public class CarritoServiceImpl implements CarritoService{

    public List<Product> listadoProductos;

    public CarritoServiceImpl(List<Product> listadoProductos) {
        this.listadoProductos = listadoProductos;
    }

    @Override
    public void agregarItem(Object item) {
        Product newProduct = (Product) item;
        this.listadoProductos.add(newProduct);
    }

    @Override
    public List<Object> buscarItem(Long id) {

        System.out.println(id);

        this.listadoProductos = listadoProductos.stream()
                .filter(p -> p.getId() == id)
                .toList();

        return Arrays.asList(this.listadoProductos.stream()
                .filter(p -> p.getId() == id)
                .toArray());
    }


    @Override
    public List<Object> eliminarItem(Long id) {

        System.out.println(id);

         this.listadoProductos = listadoProductos.stream()
                .filter(p -> p.getId() != id)
                .toList();

         return Arrays.asList(listadoProductos);
    }

    @Override
    public List<Object> listarItems() {
        return Arrays.asList(this.listadoProductos.toArray());
    }

    public List<Product> getListadoProductos() {
        return listadoProductos;
    }

    public void setListadoProductos(List<Product> listadoProductos) {
        this.listadoProductos = listadoProductos;
    }
}
