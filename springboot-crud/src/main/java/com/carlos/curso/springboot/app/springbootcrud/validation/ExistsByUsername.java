package com.carlos.curso.springboot.app.springbootcrud.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistsByUsernameValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExistsByUsername {
    String message() default "Este usuario ya existe en la base de datos!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
