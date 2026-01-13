package com.example.ecommerce.exceptions;

public class QueryParamsException extends AppError {
    public QueryParamsException(String message) {
        super(message, 400);
    }
}