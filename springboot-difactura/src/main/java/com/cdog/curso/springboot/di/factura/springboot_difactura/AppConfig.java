package com.cdog.curso.springboot.di.factura.springboot_difactura;


import com.cdog.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.cdog.curso.springboot.di.factura.springboot_difactura.models.Product;
import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:data.properties", encoding = "ISO-8859-1")
})
public class AppConfig {

    //@Primary
    @Bean //Creamos la lista de items como componente
    List<Item> itemsInvoice(){
        Product p1 = new Product("Camara Sony", 800);
        Product p2 = new Product("Biscicleta Bianchi 26", 200);

        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));

    }


    @Bean("default") //Creamos la lista de items como componente
    List<Item> itemsInvoiceOficina(){
        Product p1 = new Product("Monitor Asus 24", 700);
        Product p2 = new Product("Notebook Razer", 2400);
        Product p3 = new Product("Impresora HP", 800);
        Product p4 = new Product("Escritorio Oficina", 900);

        return Arrays.asList(new Item(p1, 2), new Item(p2, 4), new Item(p3, 6), new Item(p4, 4));

    }
}
