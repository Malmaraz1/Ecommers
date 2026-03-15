package com.example.ecommerce.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.stripe.Stripe;

import jakarta.annotation.PostConstruct;
@Configuration
public class StripeConfig {
    @Value("${stripe.api.key}")
    private String key;

    @PostConstruct 
    public void init() {
        Stripe.apiKey = key;
        System.out.println(">>> Stripe configurado con éxito <<<");
    }
    
}
