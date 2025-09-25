package com.carlos.curso.springboot.app.springbootcrud.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsExitsDbValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsExistDb {

    String message() default "Ya existe en la base de datos! @IsExistDb";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
