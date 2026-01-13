package com.example.ecommerce.Model;

import java.time.LocalDate;

import lombok.Getter;
@Getter
public class Tarjeta implements MedioPago {
    private String numeroTarjeta; // Los 16 dígitos
    private String cvv;
    private LocalDate fechaCaducidad;
    private Usuario usuario;
    private String emailTitular;
    private String dniTitular;
    private String direccion;
    private PaisOrigen paisOrigen;

    public boolean esValidaAlMomento() {
        return fechaCaducidad != null && fechaCaducidad.isAfter(LocalDate.now());
    }

    public String optenerMascaraSeguridad() {
        if (!numeroTarjeta.isEmpty() && numeroTarjeta.length() > 4) {
            return " **** **** **** " + numeroTarjeta.substring(numeroTarjeta.length() - 4);
        }
        return "***";
    }

    @Override
    public void procesarPago() {
        if (!esValidaAlMomento()) {
        throw new RuntimeException("La tarjeta está vencida");
    }
        
    }


   

}
