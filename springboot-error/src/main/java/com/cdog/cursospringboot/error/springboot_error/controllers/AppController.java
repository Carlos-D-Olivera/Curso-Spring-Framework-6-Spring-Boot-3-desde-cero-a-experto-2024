package com.cdog.cursospringboot.error.springboot_error.controllers;

import com.cdog.cursospringboot.error.springboot_error.models.domain.User;
import com.cdog.cursospringboot.error.springboot_error.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(){
        //int value = 100/0;
        int value = Integer.parseInt("10x");
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User showUser(@PathVariable(name = "id") Long id){

        User user = userService.findById(id);
        System.out.println(user.getLastname());
        return user;
    }
}
