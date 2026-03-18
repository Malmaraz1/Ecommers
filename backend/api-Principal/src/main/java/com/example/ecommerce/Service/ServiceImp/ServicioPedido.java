package com.example.ecommerce.Service.ServiceImp;

import com.example.ecommerce.Dto.PedidoDto;




public interface ServicioPedido {

 PedidoDto generarPedido(Long carritoId );
 PedidoDto getPedido(Long pedido_id);


    
}
