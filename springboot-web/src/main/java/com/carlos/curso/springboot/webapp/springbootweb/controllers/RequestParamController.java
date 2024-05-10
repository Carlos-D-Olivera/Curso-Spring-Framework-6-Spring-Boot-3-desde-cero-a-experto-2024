package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import com.carlos.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import com.carlos.curso.springboot.webapp.springbootweb.models.dto.ParamMixDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/params")
@RestController
public class RequestParamController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola que tal", name="mensaje") String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code){
        ParamMixDto param = new ParamMixDto();
        param.setMessage(text);
        param.setCode(code);
        return param;
    }


    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request){
        Integer code = 10;
        try{
            code = Integer.parseInt(request.getParameter("code"));
        }catch(NumberFormatException e){
            System.out.println("No se pudo convertir code a Integer");
        }
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }

    @GetMapping("/tabla")
    public List<String> ParamTabla(@RequestParam(name="numero") Byte number){

        List<String> tabla = new ArrayList<>();

        for(int i=10; i>=0; i--){
            int multiplicacion = number*i;
            tabla.add(
                    number.toString().concat(" * ")
                            .concat(String.valueOf(i))
                            .concat(" = ")
                            .concat(String.valueOf(multiplicacion))
            );
        }
        return tabla;
    }

}
