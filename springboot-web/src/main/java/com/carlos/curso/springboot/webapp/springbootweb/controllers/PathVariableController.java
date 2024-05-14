package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import com.carlos.curso.springboot.webapp.springbootweb.models.User;
import com.carlos.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/var")
@RestController
public class PathVariableController {

    //Estos valores son inyectados por spring automaticamente con la anotacion @Value
    @Value("${config.username}") //Con el @Value obtenemos las variables de la configuracion.
    private String username;

//    @Value("${config.message}")
//    private String message;

    @Value("${config.listOfValues}")
    private String[] listOfValues;

    @Value("${config.code}")
    private Integer code;

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

    @GetMapping("/values")
                                    //Tambien se puede colocar de esta manera para que se inyecte automaticamente y devolverlo en el metodo
    public Map<String, Object> values(@Value("${config.message}") String message){
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("listOfValues", listOfValues);

        return json;

    }
}
