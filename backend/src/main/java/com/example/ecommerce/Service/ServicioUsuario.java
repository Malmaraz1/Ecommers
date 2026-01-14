package com.example.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Model.Dto.UsuarioDto;
import com.example.ecommerce.Model.Dto.Request.UsuarioRequestDto;
import com.example.ecommerce.Repository.RepositorioUsuario;

import com.example.ecommerce.Model.Usuario;

import com.example.ecommerce.Service.ServiceImp.ServicioUsuarioImp;

@Service
public class ServicioUsuario implements ServicioUsuarioImp {

    @Autowired
    RepositorioUsuario repositorioUsuario;

    @Override
    public UsuarioDto inciarSesion(UsuarioRequestDto usuarioRequestDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inciarSesion'");
    }

    @Override
    public UsuarioDto registrarse(UsuarioRequestDto usuarioRequestDto) {
       return new UsuarioDto(null, null);

    }

    @Override
    public void cerrarSesion(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cerrarSesion'");
    }
   

}
