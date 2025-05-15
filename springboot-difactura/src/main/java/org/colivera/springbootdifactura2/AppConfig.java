package org.colivera.springbootdifactura2;

import org.colivera.springbootdifactura2.models.Item;
import org.colivera.springbootdifactura2.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    //Creamos un componente de manera manual (Bean) para una lista de Items
    @Bean
    List<Item> itemsInvoice(){

        Product p1 = new Product("LENOVO PC GAME LOQ i5 8gb RAM", 3400000);
        Product p2 = new Product("SAMSUMG A35 5G 256GB 8GB", 800000);
        Product p3 = new Product("SANDUCHERA", 20000);

        return Arrays.asList(
                new Item(p1, 1),
                new Item(p2, 2),
                new Item(p3, 4)
        );

    }

    @Bean("default")
    List<Item> itemsInvoiceOficina(){

        Product p1 = new Product("Monitor Asus 24'", 3400000);
        Product p2 = new Product("Notebook Razer", 2400000);
        Product p3 = new Product("Mouse gamer loq", 45000);
        Product p4 = new Product("Escritorio oficina", 350000);

        return Arrays.asList(
                new Item(p1, 3),
                new Item(p2, 2),
                new Item(p3, 1),
                new Item(p4, 5)
        );

    }

}
