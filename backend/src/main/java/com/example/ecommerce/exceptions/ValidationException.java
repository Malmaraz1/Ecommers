package com.example.ecommerce.exceptions;

public class ValidationException extends AppError {
    public ValidationException(String message) {
        super(message, 400);
    }
}
