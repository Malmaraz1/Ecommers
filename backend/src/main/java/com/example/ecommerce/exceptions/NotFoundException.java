package com.example.ecommerce.exceptions;
    
    public class NotFoundException extends AppError {
    public NotFoundException(String message) {
        super(message, 404);
    }
}



