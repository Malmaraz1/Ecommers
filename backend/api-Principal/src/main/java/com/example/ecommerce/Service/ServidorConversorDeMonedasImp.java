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

    private double exchangeRate;
    @Value("${api.fastforex.key}")
    private String API_KEY;
    private final String URL = "//api.fastforex.io/fetch-one?from=ARS&to=BRL&api_key=" + API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Scheduled(fixedRate = 3600000)
    public void updateExchangeRate() {
        try {
            // Hacemos el GET a la API
            ExchangeResponse response = restTemplate.getForObject(URL, ExchangeResponse.class);
            if (response != null) {
                this.exchangeRate = response.getRateFor("BRL");
                System.out.println("Tasa ARS -> BRL actualizada: " + exchangeRate);
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar moneda: " + e.getMessage());
        }
    }

    public double getExchangeRate() {
        return this.exchangeRate;
    }
}
