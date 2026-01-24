package com.example.ecommerce.middlewares;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ecommerce.exceptions.AppError;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @Value("${spring.profiles.active:prod}")
    private String env;

    // 1. ATRAPA TUS EXCEPCIONES PERSONALIZADAS (AppError y sus hijas)
    @ExceptionHandler(AppError.class)
    public ResponseEntity<Map<String, Object>> handleAppError(AppError ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", "fail");
        body.put("message", ex.getMessage());

        if ("desarrollo".equals(env)) {
            body.put("error", ex.getClass().getSimpleName());
            body.put("stack", ex.getStackTrace());
        }

        return ResponseEntity.status(ex.getStatusCode()).body(body);
    }

    // 2. ATRAPA LOS ERRORES DE VALIDACIÓN (@Valid / @NotNull / etc)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", "fail");

        // Extraemos los mensajes de error de cada campo
        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        body.put("message", "Datos de validación inválidos: " + errors);
        return ResponseEntity.status(400).body(body);
    }

    // 3. ATRAPA ERRORES GENÉRICOS (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericError(Exception ex) {
        // ESTO ES VITAL: Imprime el error real en tu terminal de Java
        ex.printStackTrace();

        Map<String, Object> body = new HashMap<>();
        body.put("status", "error");

        // Cambiamos el chequeo para que sea más flexible
        if ("desarrollo".equalsIgnoreCase(env)) {
            body.put("message", ex.getMessage());
            body.put("error_type", ex.getClass().getName());
        } else {
            body.put("message", "Algo salió mal internamente");
        }

        return ResponseEntity.status(500).body(body);
    }

}
