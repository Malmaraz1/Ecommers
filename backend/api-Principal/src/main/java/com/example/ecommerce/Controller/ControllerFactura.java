package com.example.ecommerce.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Dto.FacturaDto;

import com.example.ecommerce.Service.ServicioFactura;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/facturas")
public class ControllerFactura {

    @Autowired
    ServicioFactura servicioFactura;

    @GetMapping("{facturaId}")
    public ResponseEntity<FacturaDto> usuarioActual(@PathVariable Long facturaId) {

        FacturaDto facturaDto = servicioFactura.facturaActual(facturaId);

        return ResponseEntity.ok(facturaDto);

    }

}
