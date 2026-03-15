package com.example.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ecommerce.Record.ExchangeResponse;
import com.example.ecommerce.Service.ServiceImp.ServicioConversorMonedas;

@Service
public class ServidorConversorDeMonedasImp implements ServicioConversorMonedas {

    private double exchangeRate = 0.0; // Valor por defecto

    @Value("${api.fastforex.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    // Helper para construir la URL dinámicamente
    private String getFullUrl() {
        return "https://api.fastforex.io/fetch-one?from=ARS&to=BRL&api_key=" + apiKey;
    }

    @Override
    @Scheduled(fixedRate = 3600000)
    public void updateExchangeRate() {
        try {
            // Usamos el método para obtener la URL con la Key ya inyectada
            ExchangeResponse response = restTemplate.getForObject(getFullUrl(), ExchangeResponse.class);
            if (response != null) {
                this.exchangeRate = response.getRateFor("BRL");
                System.out.println("Tasa ARS -> BRL actualizada: " + exchangeRate);
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar moneda: " + e.getMessage());
        }
    }

    public double getExchangeRate() {
        return (this.exchangeRate > 0) ? this.exchangeRate : 1.0;
    }
}