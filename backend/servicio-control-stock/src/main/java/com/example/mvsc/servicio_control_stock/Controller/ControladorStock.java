package com.example.mvsc.servicio_control_stock.Controller;

import java.net.Authenticator.RequestorType;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvsc.servicio_control_stock.Dto.StockDto;
import com.example.mvsc.servicio_control_stock.Dto.RequestDto.RequestStock;

import com.example.mvsc.servicio_control_stock.Service.ServicioStock;

@RestController
@RequestMapping("stock")
public class ControladorStock {

    @Autowired
    ServicioStock servicioStock;

    @PostMapping()
    public ResponseEntity<RequestStock> crearStock(@RequestBody RequestStock requestStock) {

        servicioStock.crearStock(requestStock);
        return ResponseEntity.ok(requestStock);
    }

    @GetMapping("idStock")
    public ResponseEntity<StockDto> detalle(@PathVariable Long idStock) {

        return ResponseEntity.ok(servicioStock.detalle(idStock));

    }
}
