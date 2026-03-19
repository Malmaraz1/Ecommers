package com.example.ecommerce.Dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Model.Usuario;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturaDto {

    private Long id;

    private String numeroFactura;

    private LocalDate fechaEmision;

    private Usuario comprador;
    
    private List<ItemFacturaDto> itemsFactura = new ArrayList<>();

    private int total_factura;

    private Pedido pedido;

}
