package com.example.ecommerce.Service;

import org.springframework.stereotype.Service;

import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Service.ServiceImp.ServicioPago;
@Service
public class ServicioPagoImp implements ServicioPago {

    @Override
    public void realizarPago(Pedido pedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'realizarPago'");
    }

    @Override
    public void cancelarPago(Pedido pedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarPago'");
    }
    

    
}
