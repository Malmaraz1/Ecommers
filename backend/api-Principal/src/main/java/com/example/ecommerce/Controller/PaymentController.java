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
import com.example.ecommerce.Service.ServicioPagoImp;
import com.example.ecommerce.Service.ServicioPedidoImp;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

import lombok.extern.slf4j.Slf4j;

@RestController

@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    ServicioPagoImp servicioPagoImp;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    ServicioPedidoImp servicioPedidoImp;

    @PostMapping("/checkout/{pedidoId}")
    public ResponseEntity<String> createCheckout(@PathVariable Long pedidoId) throws StripeException {
        // request trae el ID del producto, NO el precio
        String urlDePago = servicioPagoImp.realizarPago(pedidoId);
        return ResponseEntity.ok(urlDePago);
    }

    @GetMapping("/success")
    public ResponseEntity<PagoExitosoResponse> confirmarPago(@RequestParam("session_id") String sessionId)
            throws StripeException {

        Session session = Session.retrieve(sessionId);
        Long pedidoIdReal = Long.parseLong(session.getMetadata().get("pedido_id"));

        servicioPagoImp.marcarComoPagado(pedidoIdReal);

        PedidoDto pedidoDto = servicioPedidoImp.getPedido(pedidoIdReal);

        System.out.print(pedidoDto);
        rabbitTemplate.convertAndSend("cola.facturacion", pedidoDto);

        return ResponseEntity.ok(new PagoExitosoResponse(
                "COMPLETADO",
                "Servidor: Pago procesado y stock reservado.",
                pedidoIdReal,
                LocalDateTime.now().toString()));
    }
}
