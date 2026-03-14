package com.example.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Service.ServicioPagoImp;
import com.stripe.exception.StripeException;
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    ServicioPagoImp servicioPagoImp;

    @PostMapping("/checkout")
    public ResponseEntity<String> createCheckout(@RequestBody Pedido pedidoRequest) throws StripeException {
        // request trae el ID del producto, NO el precio
        String urlDePago = servicioPagoImp.realizarPago(pedidoRequest);
        return ResponseEntity.ok(urlDePago);
    }
    
}
