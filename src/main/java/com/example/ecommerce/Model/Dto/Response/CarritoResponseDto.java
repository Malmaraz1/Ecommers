package com.example.ecommerce.Model.Dto.Response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.Model.ItemCarrito;
import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Model.Usuario;

public class CarritoResponseDto {

    private Usuario comprador;
   private List<ItemCarrito> itemsCarrito = new ArrayList<>();
   private LocalDate ultimaActualizacion;
   private Pedido pedido;
   public CarritoResponseDto(Usuario comprador, List<ItemCarrito> itemsCarrito, Pedido pedido) {
    this.comprador = comprador;
    this.itemsCarrito = itemsCarrito;
    this.ultimaActualizacion = LocalDate.now();
    this.pedido = pedido;
   }
    
}
