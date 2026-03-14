package com.example.ecommerce.Record;

import java.util.Map;

public record ExchangeResponse(Map<String, Double> result) {

    public Double getRateFor(String currency) {
        if (result != null && result.containsKey(currency)) {
            return result.get(currency);
        }
        return 0.0;
    }

}
