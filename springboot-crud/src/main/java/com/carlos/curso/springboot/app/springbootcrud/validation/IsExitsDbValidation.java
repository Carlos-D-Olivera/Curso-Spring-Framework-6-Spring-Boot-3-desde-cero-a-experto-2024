package com.carlos.curso.springboot.app.springbootcrud.validation;

import com.carlos.curso.springboot.app.springbootcrud.services.IProductService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class IsExitsDbValidation implements ConstraintValidator<IsExistDb, String> {

    @Autowired
    private IProductService service;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return (s!=null && !service.exitsBySku(s));
    }
}
