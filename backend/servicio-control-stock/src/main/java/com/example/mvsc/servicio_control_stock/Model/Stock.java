package com.example.mvsc.servicio_control_stock.Model;

import java.time.LocalDate;

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

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "deposito_id")
    private Deposito deposito;
    @Column(name = "producto_id")
    private Long producto_id;
    private Integer cantidad;
    private Integer punto_reposicion;
    private Integer stock_maximo;
    private String detalle;
    private LocalDate proxima_reposicion;

    public Stock(Deposito deposito, Long producto_id, Integer cantidad, Integer punto_reposicion, Integer stock_maximo,
            String detalle, LocalDate proxima_reposicion) {
        this.deposito = deposito;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.punto_reposicion = punto_reposicion;
        this.stock_maximo = stock_maximo;
        this.detalle = detalle;
        this.proxima_reposicion = proxima_reposicion;
    }

}
