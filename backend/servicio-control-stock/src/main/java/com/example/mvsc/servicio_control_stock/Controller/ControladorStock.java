package com.example.mvsc.servicio_control_stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    

}
