package com.example.ecommerce.Security.filter;

import javax.crypto.SecretKey;

import io.jsonwebtoken.security.Keys;

public class TokenJwtConfig {
    private static final String SECRET_STRING = "esta_es_una_clave_secreta_muy_larga_para_mi_ecommerce_2026";
    public static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_STRING.getBytes());
    public static String PREFIX_TOKEN = "Bearer ";
    public static String HEADER_AUTHORIZATION = "Authorization";
    public static String CONTENT_TYPE = "application/json";
}
