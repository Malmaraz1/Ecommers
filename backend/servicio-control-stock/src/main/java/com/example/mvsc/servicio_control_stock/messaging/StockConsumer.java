package com.example.mvsc.servicio_control_stock.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mvsc.servicio_control_stock.Dto.PedidoMensajeDTO;
import com.example.mvsc.servicio_control_stock.Service.ServicioStock;


@Component
public class StockConsumer {
    @Autowired
    private ServicioStock servicioStock;

    @RabbitListener(queues = "cola.facturacion")
    public void recibirPedidoYRestarStock(PedidoMensajeDTO datos) {
        if (datos == null || datos.getItemPedidoDto() == null) {
        System.err.println("❌ Error: Se recibió un mensaje vacío o sin items.");
        return; 
    }


    
    datos.getItemPedidoDto().forEach(item -> {
        System.out.println("DEBUG: Procesando Producto ID: " + item.getProductoId() + " - Cantidad: " + item.getCantidad());
        servicioStock.descontarStock(item.getProductoId(), item.getCantidad());
    });
    }
}
