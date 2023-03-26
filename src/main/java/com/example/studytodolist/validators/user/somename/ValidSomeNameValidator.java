package com.example.studytodolist.validators.user.somename;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidSomeNameValidator implements ConstraintValidator<ValidSomeName, String> {

    public boolean isValid(String firstName, ConstraintValidatorContext context) {
        if (firstName == null || firstName.isEmpty()) {
            return false;
        }


//        if (!firstName.matches(".*[a-zA-Z].*") || !firstName.matches(".*\\d.*")) {
//            return false;
//        }
        if (!firstName.matches("^[a-zA-Z]*$")) {
            return false;
        }

        return true;
    }
}