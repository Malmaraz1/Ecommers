package com.example.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Dto.CategoriaDto;
import com.example.ecommerce.Dto.Request.CategoriaRequestDto;
import com.example.ecommerce.Service.ServiceImp.ServicioCategoria;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class ControllerCategoria {

    @Autowired
    ServicioCategoria servicioCategoria;

    @PostMapping()
    public ResponseEntity<CategoriaDto> nuevaCategoria(@Valid @RequestBody CategoriaRequestDto categoriaRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(servicioCategoria.categoriaNueva(categoriaRequestDto));

    }

}
