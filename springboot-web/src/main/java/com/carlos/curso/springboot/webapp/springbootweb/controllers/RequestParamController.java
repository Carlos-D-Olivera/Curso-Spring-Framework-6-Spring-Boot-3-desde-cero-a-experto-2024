package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import com.carlos.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/params")
@RestController
public class RequestParamController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola que tal", name="mensaje") String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
}
