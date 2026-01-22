package com.example.mvsc.servicio_control_stock.Dto.RequestDto;

import com.example.mvsc.servicio_control_stock.Model.DatosContacto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class RequestDeposito {
    @NotNull(message = "falta detalle del deposito")
    @Max(value = 300 ,message = "el detalle es muy largo")
    private String detalle;
    @NotNull(message = "falta datos de contacto")
    private DatosContacto datosContacto;
}
