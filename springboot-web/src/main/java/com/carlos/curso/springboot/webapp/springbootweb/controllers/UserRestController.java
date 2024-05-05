package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//   RestController: Es una combinacion entre @Controller y @RestController
//    ¬ Se usa para indicar que todos los valores devueltos por lo metodos seran enviados directamente a la respuesta HTTP en vez de una vista renderizada
//@RestController
@Controller
@RequestMapping("/api")
public class UserRestController {

    //Usando un Map para pasar los datos
    //@GetMapping("/details") es la abrevacion para @RequestMapping(path="/details", method=RequestMethod.GET)
    @RequestMapping(path="/details", method=RequestMethod.GET) //Es lo mismo que @GetMapping, @RequestMapping por defecto es de tipo GET pero se le puede especificar el tipo con el atributo method method=RequestMethod.GET
    @ResponseBody //Si se esta usando Controller y no restController toca poner esta anotacion para indicar que la respuesta se manda directamente
    public Map<String, Object> details(){

        Map<String, Object> body = new HashMap<>();

        body.put("title","Hola mundo en Spring boot con Map");
        body.put("name", "Carlos");
        body.put("lastName","Olivera");
        body.put("age", "19");

        return body; //se devuelve directamente el valor del objeto
    }
}
