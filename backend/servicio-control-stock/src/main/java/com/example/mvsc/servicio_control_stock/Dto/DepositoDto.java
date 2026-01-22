package com.example.mvsc.servicio_control_stock.Dto;

import com.example.mvsc.servicio_control_stock.Model.DatosContacto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositoDto {
    private Long id;
    private String detalle;
    private DatosContacto datosContacto;
    public DepositoDto(Long id, String detalle, DatosContacto datosContacto) {
        this.id = id;
        this.detalle = detalle;
        this.datosContacto = datosContacto;
    }

}
