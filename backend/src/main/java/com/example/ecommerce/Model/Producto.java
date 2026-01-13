package com.example.ecommerce.Model;

import java.time.LocalDate;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "producto")
public class Producto {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "nombre")
   private String nombre;
   @Column(name = "precio")
   private Double precio;
   @ManyToOne
   private Categoria categoria;
   @Column(name = "modelo")
   private String modelo;
   @Column(name = "fabricante")
   private String fabricante;
   @Embedded
   private PaisOrigen paisOrigen;
   @Column(name = "marca")
   private String marca;
   @Column(name = "fecha_creacion")
   private LocalDate fechaCreacion;
   @Embedded
   private Garantia meses_garantia;
   private String descripcion_productro;
   @Column(name = "imagen")
   private String imagen;

}