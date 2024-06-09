package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import com.carlos.curso.springboot.webapp.springbootweb.models.User;
import com.carlos.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    private List<String> listOfValues; //tambien se puede recibir la lista como un List<>
/*
*   En el @Value se puede usar SpEl (Lenguaje de expresion de Spring) para manipular
*   los valores que vienen del properties al momento de inyectarlos.
*/
    @Value("#{ '${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList

    ;@Value("#{ '${config.listOfValues}'.toUpperCase()}")
    private String valueString;


    @Value("#{${config.valuesMap}}") //Podemos obtener la string y convertirla a un Map automaticamente
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}") //Obtenemos solo el product colocando el punto y la llave
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private Long price;

    @Value("${config.code}")
    private Integer code;

    @Autowired  //El objeto enviroment es provisto automaticamento por Spring
    private Environment environment;

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
        Long code2 = environment.getProperty("config.code",Long.class);
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        try{
            //json.put("code2", Integer.valueOf(environment.getProperty("config.code2")));
            json.put("code2", environment.getProperty("config.code2", Long.class)); //Se le pasa el tipo de dato al cual queremos que se convierta
        }catch (NumberFormatException err){
            json.put("code2", 404);
        }
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        return json;

    }
}
