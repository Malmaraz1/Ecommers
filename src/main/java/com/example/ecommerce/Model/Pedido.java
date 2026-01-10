package com.example.ecommerce.Model;

import java.time.LocalDate;

import com.example.ecommerce.utils.GeneradorCodigo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="pedido")
public class Pedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Transient
  private OrdenCompra ordenCompra;
   @Transient
  private EstadoPedido estadoPedido;
   @Transient
  private Factura factura;

  public Pedido(Carrito carrito) {
    this.estadoPedido = new Pendiente();
    this.ordenCompra = new OrdenCompra(GeneradorCodigo.generar(),
        carrito.getItemsCarrito());
  }

  public boolean SolicitarCancelacion() {
    LocalDate limite = LocalDate.now().minusDays(5);
    return this.ordenCompra.getFechaCreacion().isAfter(limite);
  }

}
