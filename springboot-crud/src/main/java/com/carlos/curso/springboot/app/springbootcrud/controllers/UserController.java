package com.carlos.curso.springboot.app.springbootcrud.controllers;

import com.carlos.curso.springboot.app.springbootcrud.entities.User;
import com.carlos.curso.springboot.app.springbootcrud.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public List<User> list(){
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result){

        if(result.hasFieldErrors()){
            return validation(result);
        }

        return  ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }


    private ResponseEntity<?> validation(BindingResult result){
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(), "EL campo "+fieldError.getField()+" "+fieldError.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
