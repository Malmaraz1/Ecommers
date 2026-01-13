package com.example.ecommerce.exceptions;

public class ConflictException extends AppError {
    public ConflictException(String message) {
        super(message, 409);
    }
}