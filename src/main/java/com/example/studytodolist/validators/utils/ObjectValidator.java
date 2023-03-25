package com.example.studytodolist.validators.utils;

import jakarta.validation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
public class ObjectValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public ValidationErrorResponse validate(T objectToValidate){
        Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);
        if (!violations.isEmpty()) {
            List<ValidationError> errors = new ArrayList<>();
            for (ConstraintViolation<T> violation : violations) {
                String field = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                errors.add(new ValidationError(field, message));
            }
            return new ValidationErrorResponse("Invalid input data", errors);
        }
        return null;

    }
}
