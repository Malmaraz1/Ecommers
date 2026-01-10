package com.example.ecommerce.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
    @Column(name ="nombre")
    private String nombre;
    @Column(name ="correo")
    private String correo;
    @Column(name ="saldo")
    private Float saldo;
    @Column(name ="contrasenia")
    private String contrasenia;
    

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    
    }
    
    public void ingresarSaldo(Float saldo){
      if(saldo < 0){
        throw new RuntimeException("No se puede agregar Saldo negativo");
      }
        this.saldo += saldo;
    }

}