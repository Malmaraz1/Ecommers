package com.example.mvsc.servicio_control_stock.Model;

import jakarta.persistence.Embeddable;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class DatosContacto {
    @NotNull(message = "ingrese un domicilio")
    private String domicilio;
    @NotNull(message = "falta el telefono")
    private String telefono;
    @NotNull(message = "falta indicar zona")
    private String zona;
    public DatosContacto(@NotNull(message = "ingrese un domicilio") String domicilio,
            @NotNull(message = "falta el telefono") String telefono,
            @NotNull(message = "falta indicar zona") String zona) {
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.zona = zona;
    }


}
