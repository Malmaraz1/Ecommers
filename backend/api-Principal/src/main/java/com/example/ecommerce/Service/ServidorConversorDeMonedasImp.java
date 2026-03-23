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

    private double exchangeRate = 0.0;

    @Value("${api.fastforex.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    // Helper para construir la URL dinámicamente
    private String getFullUrl() {
        return "https://economia.awesomeapi.com.br/json/last/ARS-BRL";
    }

    @Override
    @Scheduled(fixedRate = 3600000)
    public void updateExchangeRate() {
        try {
            // Usamos el método para obtener la URL con la Key ya inyectada
            ExchangeResponse response = restTemplate.getForObject(getFullUrl(), ExchangeResponse.class);
            if (response != null && response.datos() != null) {

                this.exchangeRate = response.datos().bid();
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