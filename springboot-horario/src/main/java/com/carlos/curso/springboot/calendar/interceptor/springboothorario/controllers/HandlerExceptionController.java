package com.carlos.curso.springboot.calendar.interceptor.springboothorario.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //Se debe colocar ya que sera un controller para excepciones
public class HandlerExceptionController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> notFound(){

        //Creamos el map de error
        Map<String, Object> error = new HashMap<>();
        error.put("mensaje","Esta ruta no se encuentra");
        error.put("date",new Date());
        error.put("status",HttpStatus.NOT_FOUND.value()); //404: not found

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

}
