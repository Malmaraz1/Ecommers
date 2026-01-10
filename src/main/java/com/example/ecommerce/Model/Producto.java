package com.example.ecommerce.Model;

import java.time.LocalDate;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name = "producto")
public class Producto
{
   @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id; 
   @Column(name ="nombre")
   private String nombre;
   @Column(name ="precio")
   private Double precio;
   @ManyToOne
   private Categoria categoria;
   @Column(name ="modelo")
   private String modelo;
   @Column(name ="fabricante")
   private String fabricante;
   @Embedded
   private PaisOrigen paisOrigen;
   @Column(name ="marca")
   private String marca;
   @Column(name = "fecha_creacion")
   private LocalDate fechaCreacion;
   @Embedded
   private Garantia meses_garantia;
   @Column(name ="descripcion_producto")
   private String descripcion;
   private String img;


}