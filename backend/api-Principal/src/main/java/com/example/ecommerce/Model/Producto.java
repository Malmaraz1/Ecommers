package com.example.ecommerce.Model;

import java.time.LocalDate;



import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "producto", indexes = {
    @Index(name = "idx_producto_precio", columnList = "precio"),
    @Index(name = "idx_producto_nombre", columnList = "nombre")
})
public class Producto {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "nombre")
   private String nombre;
   @Column(name = "precio")
   private int precio;
   @ManyToOne
   private Categoria categoria;
   @Column(name = "modelo")
   private String modelo;
   @Column(name = "marca")
   private String marca;
   @Column(name = "fecha_creacion")
   private LocalDate fechaCreacion;
   private String descripcion_productro;
   @Column(name = "imagen")
   private String imagen;
   @Transient
   private Integer stockActual;

public void actualizarDatos(String nombre, int precio, String modelo, String marca, String descripcion, String imagen, Categoria nuevaCategoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.modelo = modelo;
        this.marca = marca;
        this.descripcion_productro = descripcion;
        this.imagen = imagen;
        this.categoria = nuevaCategoria;
    }

}