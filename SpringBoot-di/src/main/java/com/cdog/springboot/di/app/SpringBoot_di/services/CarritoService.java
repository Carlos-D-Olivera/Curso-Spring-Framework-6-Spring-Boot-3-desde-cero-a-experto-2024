package com.cdog.springboot.di.app.SpringBoot_di.services;

import java.util.List;

public interface CarritoService {

    void agregarItem(Object item);

    List<Object> buscarItem(Long id);

    List<Object> eliminarItem(Long id);

    List<Object> listarItems();

}
