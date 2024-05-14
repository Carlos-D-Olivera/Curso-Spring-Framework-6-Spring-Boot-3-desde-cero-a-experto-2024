package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import com.carlos.curso.springboot.webapp.springbootweb.models.User;
import com.carlos.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/var")
@RestController
public class PathVariableController {
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message){

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;

    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id){

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("producto", product);
        json.put("id",id);
        return json;
    }

    //Por lo general el post no lleva ruta sino la ruta base
    @PostMapping("/create")
    public User create(@RequestBody User user){
        //aqui se guardaria el usuario
        user.setName(user.getName().concat(" guardado").toUpperCase());
        return user;
    }
    
    
    //Metodo para crear un usuario mediante una ruta variable
    @PostMapping("/create/{name}/{lastname}")
    public User createByPath(@PathVariable String name, @PathVariable String lastname, @RequestParam(name="correo", defaultValue = "SIN CORREO") String email, HttpServletRequest request){
        
        //Creamos el usuario
        User u = new User();
        u.setName(name);
        u.setLastName(lastname);
        u.setEmail(email);

        int edad = 0;
        try{
            edad = Integer.parseInt(request.getParameter("edad"));
        }catch(NumberFormatException e){

        }
        u.setAge(edad);

        //se retorna el usuario creado
        return u;
        
    }
}
