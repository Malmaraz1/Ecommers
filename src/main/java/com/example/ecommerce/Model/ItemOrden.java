package com.example.ecommerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items_orden")
@Getter
@Setter
@NoArgsConstructor
public class ItemOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @Column(name = "precio_congelado")
    private Double precio;
    @Column(name = "cantidad")
    private int cantidad;

    public ItemOrden(Producto producto, Double precio, int cantidad) {
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public Double getSubtotal() {
        return this.cantidad * this.precio;
    }
    
}
