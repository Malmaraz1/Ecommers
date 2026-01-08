package com.example.ecommerce.Model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Producto
{
   private Long id; 
   private String nombre;
   private Float precio;
   private Categoria categoria;
   private String modelo;
   private String fabricante;
   private PaisOrigen paisOrigen;
   private String marca;
   private LocalDate fechaCreacion;
   private LocalDate mesesDeGarantia;
   private String descripcion;
   private String img;


}