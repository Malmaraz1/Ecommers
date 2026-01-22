package com.example.ecommerce.exceptions;

public class AlreadyExistsException extends AppError {
    public AlreadyExistsException(String message) {
        super(message, 409);
    }
}