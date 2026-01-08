package com.example.ecommerce.Model;

public class Pendiente implements EstadoPedido{
 private Pedido pedido;

 @Override
 public void gestionarPago() {
    pedido.setEstadoPedido(new Pago());
 }

 
}
