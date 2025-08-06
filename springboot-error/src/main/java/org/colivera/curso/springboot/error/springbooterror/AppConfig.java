package org.colivera.curso.springboot.error.springbooterror;

import org.colivera.curso.springboot.error.springbooterror.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    //Se declara con @Bean para que se encuentre cargado en el proyecto y sea diaponible.
    @Bean
    List<User> usersList(){

        List<User> users = new ArrayList<>();

        users.add(new User(4L, "Josefa", "Martinez"));
        users.add(new User(1L, "Carlos", "Olivera"));
        users.add(new User(5L, "Ale", "Gutierrez"));
        users.add(new User(2L, "David", "Guzman"));
        users.add(new User(3L, "Maria", "Perez"));

        return users;

    }

}
