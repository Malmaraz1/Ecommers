package com.example.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Model.Dto.Request.UsuarioRequestDto;
import com.example.ecommerce.Model.Dto.Response.UsuarioResponseDto;
import com.example.ecommerce.Service.ServiceImp.ServicioUsuarioImp;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {
    @Autowired
    ServicioUsuarioImp servicioUsuario;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioResponseDto> registrarse(@RequestBody UsuarioRequestDto usuarioRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioUsuario.registrarse(usuarioRequestDto));
    }

    @PostMapping("/sesion")
    public ResponseEntity<UsuarioResponseDto> iniciarSesion(@RequestBody UsuarioRequestDto usuarioRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioUsuario.inciarSesion(usuarioRequestDto));
    }

    @DeleteMapping("/actual")
    public ResponseEntity<Void> cerrarSesion(@RequestHeader("Authorization") String token) {
        servicioUsuario.cerrarSesion(token);
        return ResponseEntity.noContent().build();
    }

}
