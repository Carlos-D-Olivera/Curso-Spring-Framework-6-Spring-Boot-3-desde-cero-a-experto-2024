package com.carlos.curso.springboot.calendar.interceptor.springboothorario.controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {


    @GetMapping("/foo")
    public ResponseEntity<?> foo(HttpServletRequest request){ //HttpServletRequest es inyectado automaticamente por Spring
        Map<String, Object> data = new HashMap<>();
        data.put("title","Bienvenidos al sistema de atencion");
        data.put("time",new Date());

        //obtenemos el message devuelto por el interceptor en el request
        data.put("message",request.getAttribute("message"));

        return ResponseEntity.ok(data);
    }
}
