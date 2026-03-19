package com.example.ecommerce.Controller;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Dto.PedidoDto;
import com.example.ecommerce.Record.PagoExitosoResponse;

import com.example.ecommerce.Service.ServiceImp.ServicioCarrito;
import com.example.ecommerce.Service.ServiceImp.ServicioPago;
import com.example.ecommerce.Service.ServiceImp.ServicioPedido;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;



@RestController

@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    ServicioPago servicioPago;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    ServicioPedido servicioPedido;
    @Autowired
    ServicioCarrito servicioCarrito;

    @PostMapping("/checkout/{pedidoId}")
    public ResponseEntity<String> createCheckout(@PathVariable Long pedidoId) throws StripeException {
        
        String urlDePago = servicioPago.realizarPago(pedidoId);
        return ResponseEntity.ok(urlDePago);
    }

    @GetMapping("/success")
    public ResponseEntity<PagoExitosoResponse> confirmarPago(@RequestParam("session_id") String sessionId)
            throws StripeException {

        Session session = Session.retrieve(sessionId);
        Long pedidoIdReal = Long.parseLong(session.getMetadata().get("pedido_id"));

        servicioPago.marcarComoPagado(pedidoIdReal);

        PedidoDto pedidoDto = servicioPedido.getPedido(pedidoIdReal);

        System.out.print("pedido " + pedidoDto);
        rabbitTemplate.convertAndSend("cola.facturacion", pedidoDto);



        return ResponseEntity.ok(new PagoExitosoResponse(
                "COMPLETADO",
                "Servidor: Pago procesado y stock reservado.",
                pedidoIdReal,
                LocalDateTime.now().toString()));
    }

    
}
