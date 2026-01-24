package com.example.mvsc.servicio_control_stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvsc.servicio_control_stock.Dto.DepositoDto;
import com.example.mvsc.servicio_control_stock.Model.Deposito;
import com.example.mvsc.servicio_control_stock.Service.ServicioDeposito;

import jakarta.validation.Valid;

@RestController
@RequestMapping("deposito")
public class ControladorDeposito {

    @Autowired
    ServicioDeposito servicioDeposito;

    @PostMapping
    public ResponseEntity<DepositoDto> crearDeposito(@Valid @RequestBody Deposito deposito) {

        return ResponseEntity.ok(servicioDeposito.crearDeposito(deposito));

    }

}
