package com.example.mvsc.servicio_control_stock.Dto;

import java.time.LocalDate;



import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class StockDto {

    private Long id_stock;
    private Long id_deposito;
    private Long producto_id;
    private Integer cantidad;
    private Integer punto_reposicion;
    private Integer stock_maximo;
    private String detalle;
    private LocalDate proxima_reposicion;

}


