package com.example.ecommerce.Service.ServiceImp;

import com.example.ecommerce.Model.Pedido;
import com.stripe.exception.StripeException;

public interface ServicioPago {
    
   String realizarPago(Long pedidoId) throws StripeException;
   void cancelarPago(Pedido pedido);
   
}
