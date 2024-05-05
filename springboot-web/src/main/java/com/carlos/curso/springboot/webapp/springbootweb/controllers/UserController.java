package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.carlos.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {
    //GetMapping se usa para     
    @GetMapping("/details")    // ¬ el Model es inyectado por Spring automaticamente para pasarle datos a la vista (inyeccion de dependencias)
    public String details(Model model){
        
        User user = new User("Carlos", "Olivera", 19);

        model.addAttribute("title", "Hola mundo en Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

}
