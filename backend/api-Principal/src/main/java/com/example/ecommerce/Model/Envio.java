package com.example.ecommerce.Model;

public class Envio implements EstadoPedido{
     private Pedido pedido;
    @Override
    public void gestionarPago() {
     
    }
    public void cambioEstado(){
        if(pedido.SolicitarCancelacion()){
            pedido.setEstadoPedido(new Cancelado());
        }
    }
  
}
