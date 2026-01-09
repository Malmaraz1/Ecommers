package com.example.ecommerce.Service.ServiceImp;

import com.example.ecommerce.Model.Pedido;

public interface ServicioPagoImp {
    
   void realizarPago(Pedido pedido);
   void cancelarPago(Pedido pedido);
   
}
