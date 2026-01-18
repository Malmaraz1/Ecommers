package com.example.ecommerce.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.Model.Rol;
import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Model.Dto.UsuarioDto;
import com.example.ecommerce.Model.Dto.Request.UsuarioRequestDto;
import com.example.ecommerce.Repository.RepositorioRol;
import com.example.ecommerce.Repository.RepositorioUsuario;

import com.example.ecommerce.Service.ServiceImp.ServicioUsuarioImp;

@Service
public class ServicioUsuario implements ServicioUsuarioImp {

    @Autowired
    RepositorioUsuario repositorioUsuario;
    @Autowired
    RepositorioRol repositorioRol;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UsuarioDto inciarSesion(UsuarioRequestDto usuarioRequestDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inciarSesion'");
    }

    @Override
    @Transactional
    public UsuarioDto registrarse(UsuarioRequestDto usuarioRequestDto) {
        Optional<Rol> rol = repositorioRol.findByName("ROLE_USER");
        Set<Rol> roles = new HashSet<>();
        rol.ifPresent(roles::add);

        if (usuarioRequestDto.isAdmin()) {
            Optional<Rol> rolAdmin = repositorioRol.findByName("ROLE_ADMIN");

            rolAdmin.ifPresent(roles::add);
        }

        Usuario usuario = new Usuario();
        usuario.setContrasenia(passwordEncoder.encode(usuarioRequestDto.getContrasenia()));
        usuario.setCorreo(usuarioRequestDto.getEmail());
        usuario.setNombre(usuarioRequestDto.getNombre());
        usuario.setRoles(roles);
        repositorioUsuario.save(usuario);
        return new UsuarioDto(usuarioRequestDto.getNombre(),
                usuarioRequestDto.getEmail(), usuario.getId());

    }

    @Override
    @Transactional
    public void cerrarSesion(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cerrarSesion'");
    }

}
