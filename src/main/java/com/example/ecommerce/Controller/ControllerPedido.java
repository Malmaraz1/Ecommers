package com.example.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Model.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Pedido;

import com.example.ecommerce.Service.ServiceImp.ServicioPedidoImp;

@RestController
@RequestMapping("/pedidos")
public class ControllerPedido {

   @Autowired
   ServicioPedidoImp servicioPedidoImp;

   @PostMapping
   public ResponseEntity<Pedido> generarPedido(@RequestBody CarritoRequestDto carritoRequestDto) {
      return ResponseEntity.status(HttpStatus.CREATED).body(servicioPedidoImp.generarPedido(carritoRequestDto));

   }

}
