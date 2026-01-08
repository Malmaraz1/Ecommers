package com.example.ecommerce.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemOrden {
   private Producto producto;
   private float precio;
   private int cantidad;
   public ItemOrden(Producto producto, float precio) {
    this.producto = producto;
    this.precio = precio;
   }

    public Float getSubtotal(){
        return  this.cantidad * producto.getPrecio();
    }
   
}
