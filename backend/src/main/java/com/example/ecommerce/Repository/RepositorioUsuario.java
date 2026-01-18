package com.example.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Model.Dto.UsuarioDto;
import com.example.ecommerce.Model.Dto.Request.UsuarioRequestDto;

public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {
   
    UsuarioDto save(UsuarioRequestDto usuario);

}
