package com.carlos.curso.springboot.app.aop.springbootaop.controllers;

import com.carlos.curso.springboot.app.aop.springbootaop.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RequestMapping("/app")
@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting(){
        return ResponseEntity.ok(
                Collections.singletonMap("greeting"
                ,greetingService.sayHello("Pepe","Hola que tal"))
        );
    }

    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError(){
        return ResponseEntity.ok(
                Collections.singletonMap("greeting"
                ,greetingService.sayHelloError("Pepe","Hola que tal"))
        );
    }
}
