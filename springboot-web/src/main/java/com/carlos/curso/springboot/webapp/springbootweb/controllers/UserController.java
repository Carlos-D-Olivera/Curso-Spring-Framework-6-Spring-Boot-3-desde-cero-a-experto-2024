package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    //GetMapping se usa para     
    @GetMapping("/details")    // ¬ el Model es inyectado por Spring automaticamente para pasarle datos a la vista (inyeccion de dependencias)
    public String details(Model model){
        //Colocamos el nombre del atributo y luego el valor
        model.addAttribute("title", "Hola mundo en Spring Boot");
        model.addAttribute("name", "Carlos");
        model.addAttribute("lastName", "Olivera");
        model.addAttribute("age", "19");
        return "details";
    }

    //Usando un Map para pasar los datos
    @GetMapping("/details2")
    public String details2(Map<String, Object> model){
        model.put("title","Hola mundo en Spring boot con Map");
        model.put("name", "Carlos");
        model.put("lastName","Olivera");
        model.put("age", "19");

        return "details";
    }

    //Tambien se usa el modelAndView
}
