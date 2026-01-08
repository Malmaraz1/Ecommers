package com.example.ecommerce.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCarrito {
    private Integer cantidad;
    private float precioUnitario;
    private Producto producto;

    public float calcularSubTotal() {
        return cantidad * precioUnitario;
    }

    public ItemCarrito(Integer cantidad, float precioUnitario, Producto producto) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.producto = producto;
    }
 
}
