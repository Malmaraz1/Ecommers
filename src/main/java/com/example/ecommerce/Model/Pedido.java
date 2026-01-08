package com.example.ecommerce.Model;

import java.time.LocalDate;

import com.example.ecommerce.utils.GeneradorCodigo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pedido {

  private OrdenCompra ordenCompra;
  private EstadoPedido estadoPedido;
  private Factura factura;

  public Pedido(Carrito carrito) {
    this.estadoPedido = new Pendiente();
    this.ordenCompra =  new OrdenCompra(GeneradorCodigo.generar(),
        carrito.getItemsCarrito());
  }
 

  public boolean SolicitarCancelacion() {
    LocalDate limite = LocalDate.now().minusDays(5);
    return this.ordenCompra.getFechaCreacion().isAfter(limite);
  }
  
  


  
  
 



}
