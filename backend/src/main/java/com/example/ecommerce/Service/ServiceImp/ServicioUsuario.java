package com.example.ecommerce.Service.ServiceImp;

import com.example.ecommerce.Dto.UsuarioDto;
import com.example.ecommerce.Dto.Request.UsuarioRequestDto;

public interface ServicioUsuario {

    UsuarioDto inciarSesion(UsuarioRequestDto usuarioRequestDto);

    UsuarioDto registrarse(UsuarioRequestDto usuarioRequestDto);

    void cerrarSesion(String token);

    UsuarioDto registraseComoAdmin(UsuarioRequestDto usuarioRequestDto);

    boolean existByUsername(String name);

}
