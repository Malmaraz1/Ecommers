package com.example.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Service.ServiceImp.ServicioPedidoImp;
@RestController
@RequestMapping("/")
public class ControllerPedido {
    
   @Autowired
   ServicioPedidoImp servicioPedidoImp;

   public ResponseEntity <PedidoRes
    

}
