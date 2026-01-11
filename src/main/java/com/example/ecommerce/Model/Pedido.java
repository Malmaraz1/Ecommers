package com.example.ecommerce.Model;

import java.time.LocalDate;

import com.example.ecommerce.utils.GeneradorCodigo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="pedido")
public class Pedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Transient
  private OrdenCompra ordenCompra;
  @Transient
  private EstadoPedido estadoPedido;
  @OneToOne
  private Factura factura;
  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario comprador;

  public Pedido(Carrito carrito) {
    this.estadoPedido = new Pendiente();
    
  }

  public boolean SolicitarCancelacion() {
    LocalDate limite = LocalDate.now().minusDays(5);
    return this.ordenCompra.getFechaCreacion().isAfter(limite);
  }

}
