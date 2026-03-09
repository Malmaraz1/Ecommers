package com.example.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Dto.UsuarioDto;
import com.example.ecommerce.Dto.Request.ProductoRequestDto;
import com.example.ecommerce.Dto.Request.UsuarioRequestDto;
import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Service.ServicioUsuarioImp;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {
    @Autowired
    ServicioUsuarioImp servicioUsuario;

    @PostMapping("registro")
    public ResponseEntity<UsuarioDto> registrarse(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioUsuario.registrarse(usuarioRequestDto));
    }

    @DeleteMapping("actual")
    public ResponseEntity<Void> cerrarSesion(@Valid @RequestHeader("Authorization") String token) {
        servicioUsuario.cerrarSesion(token);
        return ResponseEntity.noContent().build();
    }

     @GetMapping("{usuarioId}")
    public ResponseEntity<UsuarioDto> usuarioActual(@Valid @RequestBody @PathVariable Long usuarioId){
        
        UsuarioDto usuarioDto = servicioUsuario.usuarioActual(usuarioId);
      return ResponseEntity.ok(usuarioDto);
      

    }

    
}

   
    

    


