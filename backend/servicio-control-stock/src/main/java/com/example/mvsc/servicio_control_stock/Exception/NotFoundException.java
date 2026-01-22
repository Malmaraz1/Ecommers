package com.example.mvsc.servicio_control_stock.Exception;

   public class NotFoundException extends AppError {
    public NotFoundException(String message) {
        super(message, 404);
    }
}