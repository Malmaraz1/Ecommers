package com.example.ecommerce.utils;

import java.util.UUID;

public class GeneradorCodigo {
    public static String generar() {
        return UUID.randomUUID().toString();
    }
}