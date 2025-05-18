package org.colivera.curso.springboot.error.springbooterror.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import org.colivera.curso.springboot.error.springbooterror.models.Error;

import java.util.Date;

/*  @RestControllerAdvice:
    Funciona como un controlador comun pero en vez de estar
    mapeado a una ruta o url este se encuentra asociado a una
    exception
*/
@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)//Asociamos este metodo al error ArithmeticException
    public ResponseEntity<?> divisionByZero(Exception ex){

        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division por cero!");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        //return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

}
