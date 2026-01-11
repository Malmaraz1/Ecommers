package com.example.ecommerce.Service.ServiceImp;

import com.example.ecommerce.Model.Dto.Request.UsuarioRequestDto;
import com.example.ecommerce.Model.Usuario;


public interface ServicioUsuarioImp {
  
 
    Usuario inciarSesion(UsuarioRequestDto usuarioRequestDto);
    Usuario registrarse(UsuarioRequestDto usuarioRequestDto);
    void cerrarSesion(String token);

    
}
