package org.colivera.curso.springboot.error.springbooterror.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*  @RestControllerAdvice:
    Funciona como un controlador comun pero en vez de estar
    mapeado a una ruta o url este se encuentra asociado a una
    exception
*/
@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)//Asociamos este metodo al error ArithmeticException
    public ResponseEntity<?> divisionByZero(Exception ex){

        return ResponseEntity.internalServerError().body("ERROR 500");
    }

}
