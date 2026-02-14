package com.carlos.curso.springboot.app.springbootcrud.validation;

import com.carlos.curso.springboot.app.springbootcrud.services.IUserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsByUsernameValidation implements ConstraintValidator<ExistsByUsername, String> {

    @Autowired
    private IUserService userService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean existe = userService.existByUsername(value);

        return !existe;
    }
}
