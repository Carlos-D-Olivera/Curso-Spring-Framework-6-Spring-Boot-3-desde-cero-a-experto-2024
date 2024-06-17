package com.cdog.springboot.di.app.SpringBoot_di;

import com.cdog.springboot.di.app.SpringBoot_di.repositories.ProductRepository;
import com.cdog.springboot.di.app.SpringBoot_di.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.*;


@Configuration()
@PropertySources({
        @PropertySource("classpath:valores.properties")
})
public class ConfigProperties {


    @Bean("json")
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson(); //Se puede devolver un objeto de una clase desde la clase de configuracion
    }

}
