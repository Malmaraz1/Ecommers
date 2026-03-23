package com.example.ecommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.Dto.UsuarioDto;
import com.example.ecommerce.Dto.Request.UsuarioRequestDto;
import com.example.ecommerce.Model.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {
   
    UsuarioDto save(UsuarioRequestDto usuario);
    boolean existsByNombre(String nombre);
    boolean existsByCorreo(String email);
    @Query("SELECT u from Usuario u join fetch u.roles where u.nombre = :nombre ")
    Optional<Usuario> findByNombre(@Param("nombre") String nombre);

   


}
