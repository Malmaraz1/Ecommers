package com.example.ecommerce.exceptions;

public class DoesNotBelongToUserException extends AppError {
    public DoesNotBelongToUserException(String message) {
        super(message, 403);
    }
}
