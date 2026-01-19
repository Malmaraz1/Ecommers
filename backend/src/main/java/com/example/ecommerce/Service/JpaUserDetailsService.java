package com.example.ecommerce.Service;

import java.text.CollationElementIterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;


import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Repository.RepositorioUsuario;
import com.example.ecommerce.exceptions.NotFoundException;

public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = repositorioUsuario.findByNombre(username);

        if (usuario.isEmpty()) {
            throw new NotFoundException("el usuario no esta registrado");
        }

        Usuario usuarioNuevo = usuario.orElseThrow();

        List<GrantedAuthority> authorities = usuarioNuevo.getRoles()
                .stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        ;

        return new org.springframework.security.core.userdetails.User(usuarioNuevo.getNombre(),
                usuarioNuevo.getContrasenia(), usuarioNuevo.isEnabled(), true, true, true, authorities);

    }
}