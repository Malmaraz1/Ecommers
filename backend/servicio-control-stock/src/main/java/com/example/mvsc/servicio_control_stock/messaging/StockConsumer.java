package com.example.mvsc.servicio_control_stock.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mvsc.servicio_control_stock.Dto.PedidoMensajeDTO;
import com.example.mvsc.servicio_control_stock.Service.ServicioStock;
import com.example.mvsc.servicio_control_stock.ServiceImp.ServicioStockImp;

@Component
public class StockConsumer {
    @Autowired
    private ServicioStock servicioStock;

    @RabbitListener(queues = "cola.facturacion")
    public void recibirPedidoYRestarStock(PedidoMensajeDTO datos) {
        System.out.println("📬 Mensaje recibido de RabbitMQ para el pedido: " + datos.getPedidoId());
        
   
        datos.getItems().forEach(item -> {
            servicioStock.descontarStock(item.getProductoId(), item.getCantidad());
        });
        
        System.out.println("✅ Stock actualizado exitosamente.");
    }
}
