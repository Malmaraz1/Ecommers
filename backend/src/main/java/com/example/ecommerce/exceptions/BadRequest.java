package com.example.ecommerce.exceptions;

public class BadRequest extends AppError {

    public BadRequest(String message, int statusCode) {
        super(message, 400);

    }

}
