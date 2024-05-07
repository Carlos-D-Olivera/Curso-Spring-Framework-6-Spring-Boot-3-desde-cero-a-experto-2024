package com.carlos.curso.springboot.webapp.springbootweb.controllers;

//import java.util.*;
 import java.util.HashMap;
 import java.util.Map;
 //import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.curso.springboot.webapp.springbootweb.models.User;
import com.carlos.curso.springboot.webapp.springbootweb.models.dto.UserDto;


//   RestController: Es una combinacion entre @Controller y @RestController
//    ¬ Se usa para indicar que todos los valores devueltos por lo metodos seran enviados directamente a la respuesta HTTP en vez de una vista renderizada
@RestController
@RequestMapping("/api")// ruta de primer nivel o base
public class UserRestController {

    @GetMapping("/details")// es la abrevacion para @RequestMapping(path="/details", method=RequestMethod.GET)
    public UserDto details(){

        UserDto userDto = new UserDto();
        User user = new User("Carlos", "Olivera", 19);
        userDto.setUser(user);
        userDto.setTitle("Holas mundos sen Spring boot con Map");
        System.out.println("holas");

        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){

        User user = new User("Andres","Guzman", 17);
        User user2 = new User("Pepelin","Doeff", 18);
        User user3 = new User("Jhonijk","Does", 19);

        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

//        List<User> users = new ArrayList<>(Arrays.asList(user, user2, user3));
        List<User> users = Arrays.asList(user, user2, user3);


        return users;
    }

    @GetMapping("/details-map")// es la abrevacion para @RequestMapping(path="/details", method=RequestMethod.GET)
    public Map<String, Object> detailsMap(){

        User user = new User("Carlos", "Olivera", 19);

        Map<String, Object> body = new HashMap<>();

        body.put("title","Hola mundos en Spring boot con Map");
        body.put("user", user);

        return body; //se devuelve directamente el valor del objeto
    }
}
