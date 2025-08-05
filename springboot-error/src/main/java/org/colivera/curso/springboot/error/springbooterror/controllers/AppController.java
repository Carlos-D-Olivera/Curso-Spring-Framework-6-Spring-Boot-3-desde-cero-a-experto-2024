package org.colivera.curso.springboot.error.springbooterror.controllers;

import org.colivera.curso.springboot.error.springbooterror.domain.User;
import org.colivera.curso.springboot.error.springbooterror.exceptions.UserNotFoundException;
import org.colivera.curso.springboot.error.springbooterror.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private IUserService service;

    @GetMapping
    public String index(){
//        int value = 100 / 0; //Lanzamos un error a proposito
        int value = Integer.parseInt("10x"); //Lanzamos un error numberFormatException a proposito
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id){
        User user = service.findById(id);

        if(user == null){
            throw new UserNotFoundException("Error el usuario no existe compa!");
        }
        System.out.println(user.getLastName());
        return user;
    }
}
