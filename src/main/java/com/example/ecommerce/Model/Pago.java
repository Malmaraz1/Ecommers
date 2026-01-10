package com.example.ecommerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
@Entity(name="pago")
@Getter
@Setter
public class Pago implements EstadoPedido{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Transient
  private MedioPago medioPago;
  @ManyToOne
  @JoinColumn(name="pedido_id")
  private Pedido pedido;

  public void cambioEstado(){
   
  }
  
  @Override
  public void gestionarPago() {
    
  }
 
    
 
  

  
}
