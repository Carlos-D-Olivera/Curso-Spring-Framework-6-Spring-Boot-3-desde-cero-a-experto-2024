package com.cdog.springboot.di.app.SpringBoot_di;

import com.cdog.springboot.di.app.SpringBoot_di.repositories.ProductRepository;
import com.cdog.springboot.di.app.SpringBoot_di.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;


@Configuration()
@PropertySources({
        @PropertySource("classpath:valores.properties")
})
public class ConfigProperties {

//    @Value("classpath:json/product.json") //Para obtener un archivo hay que inyectarlo desde una clase configuration que esta dentro del contexto Spring
//    private Resource resource;

    @Bean("json")
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson(); //Se puede devolver un objeto de una clase desde la clase de configuracion
    }

}
