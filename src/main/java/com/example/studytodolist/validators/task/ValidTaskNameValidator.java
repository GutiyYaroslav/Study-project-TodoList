package com.example.studytodolist.validators.task;

import com.example.studytodolist.validators.user.email.ValidEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidTaskNameValidator implements ConstraintValidator<ValidTaskName, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email != null && !email.isEmpty();
    }
}