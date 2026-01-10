package com.example.ecommerce.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemOrden {
    
   private Producto producto;
   private Double precio;
   private int cantidad;
   public ItemOrden(Producto producto, Double precio) {
    this.producto = producto;
    this.precio = precio;
   }

    public Double getSubtotal(){
        return  this.cantidad * producto.getPrecio();
    }
   
}
