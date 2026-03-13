package com.example.ecommerce.Model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "pedido")
public class Pedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Transient
  private EstadoPedido estadoPedido;
  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario comprador;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "pedido_id")
  private List<ItemCarrito> items_carrito = new ArrayList<>();

  public Pedido(Carrito carrito) {
    this.estadoPedido = new Pendiente();
    this.setItems_carrito(items_carrito);
    this.setComprador(carrito.getComprador());
    

  }


}
