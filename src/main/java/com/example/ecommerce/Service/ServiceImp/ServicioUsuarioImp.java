package com.example.ecommerce.Service.ServiceImp;

import com.example.ecommerce.Model.Dto.UsuarioDto;
import com.example.ecommerce.Model.Dto.Request.UsuarioRequestDto;



public interface ServicioUsuarioImp {
  
 
    UsuarioDto inciarSesion(UsuarioRequestDto usuarioRequestDto);
    UsuarioDto registrarse(UsuarioRequestDto usuarioRequestDto);
    void cerrarSesion(String token);

    
}
