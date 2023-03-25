package com.example.studytodolist.validators.user.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPasswordValidator.class)
@Documented
public @interface ValidPassword {

    String message() default "Invalid password: Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one special character, and one digit.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}