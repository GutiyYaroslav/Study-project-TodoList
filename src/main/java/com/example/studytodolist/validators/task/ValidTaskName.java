package com.example.studytodolist.validators.task;

import com.example.studytodolist.validators.user.email.ValidEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidTaskNameValidator.class)
public @interface ValidTaskName {

    String message() default "Invalid email address: Email must not be empty and must conform to the email format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}