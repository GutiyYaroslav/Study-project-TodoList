package com.example.studytodolist.validators;

import java.util.List;

public class ValidationErrorResponse {
    private final String message;
    private final List<ValidationError> errors;

    public ValidationErrorResponse(String message, List<ValidationError> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}