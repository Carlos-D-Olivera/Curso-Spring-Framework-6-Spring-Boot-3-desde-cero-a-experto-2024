package org.colivera.curso.springboot.error.springbooterror.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/app")
    public String index(){
//        int value = 100 / 0; //Lanzamos un error a proposito
        int value = Integer.parseInt("10x"); //Lanzamos un error numberFormatException a proposito
        return "ok 200";
    }
}
