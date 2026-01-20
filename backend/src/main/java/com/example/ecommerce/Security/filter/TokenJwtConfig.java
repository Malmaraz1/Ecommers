package com.example.ecommerce.Security.filter;


import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;

public class TokenJwtConfig {
    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    public static String PREFIX_TOKEN = "Bearer";
    public static String HEADER_AUTHORIZATION = "Authorization";
    public static String CONTENT_TYPE = "aplication/json";
}
