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
@Table(name = "items_factura")
@Getter
@Setter
@NoArgsConstructor
public class ItemFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @Column(name = "precio_congelado")
    private int precio;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "total_factura")
    private int total_factura;
    @ManyToOne
    @JoinColumn(name="factura_id")
    private Factura factura;

    public ItemFactura(Producto producto, int precio, int cantidad , Factura factura) {
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.factura = factura;
    }

   
    

}
