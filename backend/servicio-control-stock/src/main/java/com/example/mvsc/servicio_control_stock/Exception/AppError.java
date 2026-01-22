package com.example.mvsc.servicio_control_stock.Exception;

public class AppError extends RuntimeException{
     private final int statusCode;

    public AppError(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
    
}
