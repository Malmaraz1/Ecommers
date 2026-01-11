package com.example.ecommerce.Service;

import org.springframework.stereotype.Service;


import com.example.ecommerce.Model.Dto.Request.UsuarioRequestDto;
import com.example.ecommerce.Model.Usuario;

import com.example.ecommerce.Service.ServiceImp.ServicioUsuarioImp;
@Service
public class ServicioUsuario implements ServicioUsuarioImp {

    @Override
    public Usuario inciarSesion(UsuarioRequestDto usuarioRequestDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inciarSesion'");
    }

    @Override
    public Usuario registrarse(UsuarioRequestDto usuarioRequestDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarse'");
    }

    @Override
    public void cerrarSesion(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cerrarSesion'");
    }

  

  

  
    
}
