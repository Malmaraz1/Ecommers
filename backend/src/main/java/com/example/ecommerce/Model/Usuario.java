package com.example.ecommerce.Model;


import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "usuario")
@NoArgsConstructor
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "nombre")
  private String nombre;
  @Column(name = "correo")
  private String correo;
  @Column(name = "saldo")
  private Float saldo;
  @Column(name = "contrasenia")
  private String contrasenia;
  @ManyToMany
  @JoinTable(
    name = "usuario_rol",
    joinColumns = @JoinColumn(name = "user_id") ,
    inverseJoinColumns = @JoinColumn(name = "rol_id")
  )
  private Set<Rol> roles = new HashSet<>();

  public Usuario(String nombre, String correo) {
    this.nombre = nombre;
    this.correo = correo;

  }

  public void ingresarSaldo(Float saldo) {
    if (saldo < 0) {
      throw new RuntimeException("No se puede agregar Saldo negativo");
    }
    this.saldo += saldo;
  }

}