package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.curso.springboot.webapp.springbootweb.models.User;


//   RestController: Es una combinacion entre @Controller y @RestController
//    ¬ Se usa para indicar que todos los valores devueltos por lo metodos seran enviados directamente a la respuesta HTTP en vez de una vista renderizada
@RestController
@RequestMapping("/api")// ruta de primer nivel o base
public class UserRestController {

    //Usando un Map para pasar los datos
    @GetMapping("/details")// es la abrevacion para @RequestMapping(path="/details", method=RequestMethod.GET)
    public Map<String, Object> details(){

        User user = new User("Carlos", "Olivera", 19);

        Map<String, Object> body = new HashMap<>();

        body.put("title","Hola mundo en Spring boot con Map");
        body.put("user", user);

        return body; //se devuelve directamente el valor del objeto
    }
}
