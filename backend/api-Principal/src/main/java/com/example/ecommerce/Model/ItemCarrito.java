package com.example.ecommerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "item_carrito")
public class ItemCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio_unitario")
    private int precioUnitario;
    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
   

    public ItemCarrito(int cantidad, int precioUnitario, Producto producto) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.producto = producto;
    }
    public int calcularTotal(){
     return this.cantidad * precioUnitario;
    }

}
