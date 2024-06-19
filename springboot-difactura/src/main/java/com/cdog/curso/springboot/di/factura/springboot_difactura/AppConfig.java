package com.cdog.curso.springboot.di.factura.springboot_difactura;


import com.cdog.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.cdog.curso.springboot.di.factura.springboot_difactura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySources({
        @PropertySource("classpath:data.properties")
})
public class AppConfig {

    @Bean //Creamos la lista de items como componente
    List<Item> itemsInvoice(){
        Product p1 = new Product("Camara Sony", 800);
        Product p2 = new Product("Bicicleta Bianchi 26", 200);

        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));

    }
}
