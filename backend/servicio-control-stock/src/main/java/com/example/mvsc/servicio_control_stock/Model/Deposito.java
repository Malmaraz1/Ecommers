package com.example.mvsc.servicio_control_stock.Model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "deposito")
public class Deposito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String detalle;
    @Embedded
    private DatosContacto datosContacto;

    
    public Deposito(String detalle, DatosContacto datosContacto) {
        this.detalle = detalle;
        this.datosContacto = datosContacto;
    }

    

}
