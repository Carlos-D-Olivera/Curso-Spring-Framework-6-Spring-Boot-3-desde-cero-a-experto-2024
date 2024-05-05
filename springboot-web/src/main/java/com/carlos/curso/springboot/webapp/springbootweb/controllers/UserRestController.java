package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Es una combinacion entre @Controller y @RestController
//Se usa para indicar que todos los valores devueltos por lo metodos seran enviados directamente a la respuesta HTTP en vez de una vista renderizada
@RestController 
public class UserRestController {

    //Usando un Map para pasar los datos
    @GetMapping("/details3")
    public Map<String, Object> details(){

        Map<String, Object> body = new HashMap<>();

        body.put("title","Hola mundo en Spring boot con Map");
        body.put("name", "Carlos");
        body.put("lastName","Olivera");
        body.put("age", "19");

        return body; //se devuelve directamente el valor del objeto
    }
}
