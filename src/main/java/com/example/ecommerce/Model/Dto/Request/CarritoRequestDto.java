package com.example.ecommerce.Model.Dto.Request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.Model.ItemCarrito;
import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Model.Usuario;

public class CarritoRequestDto {

    private Usuario comprador;
    private List<ItemCarrito> itemsCarrito = new ArrayList<>();
    private LocalDate ultimaActualizacion;
    public CarritoRequestDto(Usuario comprador, List<ItemCarrito> itemsCarrito) {
        this.comprador = comprador;
        this.itemsCarrito = itemsCarrito;
    }

   
    
}
