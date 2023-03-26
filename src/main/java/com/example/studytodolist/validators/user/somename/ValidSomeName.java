package com.example.studytodolist.validators.user.somename;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidSomeNameValidator.class)
public @interface ValidSomeName {

    String message() default "Invalid name fields";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}