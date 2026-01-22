package com.example.ecommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.Dto.UsuarioDto;
import com.example.ecommerce.Dto.Request.UsuarioRequestDto;
import com.example.ecommerce.Model.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {
   
    UsuarioDto save(UsuarioRequestDto usuario);
    boolean existsByNombre(String nombre);
    boolean existsByCorreo(String email);
    Optional<Usuario> findByNombre(String nombre);
   


}
