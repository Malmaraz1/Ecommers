package com.example.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Model.Dto.UsuarioDto;
import com.example.ecommerce.Model.Dto.Request.UsuarioRequestDto;
import com.example.ecommerce.Repository.RepositorioUsuario;
import com.example.ecommerce.Model.Comprador;
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
        Usuario compradorUsuario = new Comprador(usuarioRequestDto.getNombre(), usuarioRequestDto.getEmail());

        Usuario compradorNuevo = repositorioUsuario.save(compradorUsuario);
        if (compradorNuevo == null) {
            throw new RuntimeException("No se pudo registrar al usuario");
        }
        return new UsuarioDto(compradorNuevo.getNombre(), compradorNuevo.getCorreo());

    }

    @Override
    public void cerrarSesion(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cerrarSesion'");
    }

}
