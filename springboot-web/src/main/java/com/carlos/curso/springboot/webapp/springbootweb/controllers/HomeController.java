package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"","/", "/home"})
    public String home(){
        return "redirect:/list"; //Se redirige a otra ruta para ejecutar otra accion
    }

    @GetMapping("/home2")
    public String home2(){
        return "forward:/details"; //Se redirige a otra ruta pero sin cambiar la peticion HTTP (url) y sin cambiar los parametros de la request
    }
}
