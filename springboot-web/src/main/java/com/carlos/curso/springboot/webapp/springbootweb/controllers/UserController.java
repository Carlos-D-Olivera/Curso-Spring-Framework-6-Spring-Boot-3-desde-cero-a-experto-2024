package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.carlos.curso.springboot.webapp.springbootweb.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    //GetMapping se usa para     
    @GetMapping("/details")    // ¬ el Model es inyectado por Spring automaticamente para pasarle datos a la vista (inyeccion de dependencias)
    public String details(Model model){
        
        User user = new User("Carlos", "Olivera", 19, "carlosdavidoliverag@gmail.com");
        user.setEmail("cdog@gmail.com");
        model.addAttribute("title", "Hola mundo en Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    //ModelMap es un objeto de Spring parecido al Model que a la final implementa un map
    @GetMapping("/list")
    public String list(ModelMap model){
        List<User> users =  Arrays.asList(
            new User("Juancho", "Perez", 22, "juan@gmail.com"),
            new User("Pepe", "Rodriguez", 19, "pepe@outlook.com"),
            new User("Andres", "Ochoa", 64),
            new User("Maria", "Gonzales", 25, "maria@hotmail.com")
        );

        //users = new ArrayList<>();
        model.addAttribute("users",users);
        model.addAttribute("title","Listado de Usuarios");
        return "list";
    }

}
