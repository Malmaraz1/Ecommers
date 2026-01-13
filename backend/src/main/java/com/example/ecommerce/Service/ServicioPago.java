package com.example.ecommerce.Service;

import org.springframework.stereotype.Service;

import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Service.ServiceImp.ServicioPagoImp;
@Service
public class ServicioPago implements ServicioPagoImp {

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
