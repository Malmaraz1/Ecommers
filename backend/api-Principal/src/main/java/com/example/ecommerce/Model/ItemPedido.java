package com.example.ecommerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio_unitario")
    private int precioUnitario;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public int calcularTotal() {
        return this.cantidad * precioUnitario;
    }

}
