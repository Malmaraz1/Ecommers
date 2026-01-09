package com.example.ecommerce.Service.ServiceImp;

import com.example.ecommerce.Model.Dto.Request.UsuarioRequestDto;
import com.example.ecommerce.Model.Dto.Response.UsuarioResponseDto;

public interface ServicioUsuarioImp {
  
 
    UsuarioResponseDto inciarSesion(UsuarioRequestDto usuarioRequestDto);
    UsuarioResponseDto registrarse(UsuarioRequestDto usuarioRequestDto);
    void cerrarSesion(String token);

    
}
