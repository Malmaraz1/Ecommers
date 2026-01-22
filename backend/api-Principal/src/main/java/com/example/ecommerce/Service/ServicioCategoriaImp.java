package com.example.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.Dto.CategoriaDto;
import com.example.ecommerce.Dto.Request.CategoriaRequestDto;
import com.example.ecommerce.Model.Categoria;
import com.example.ecommerce.Repository.RepositorioCategoria;
import com.example.ecommerce.Service.ServiceImp.ServicioCategoria;

import jakarta.validation.Valid;

@Service
public class ServicioCategoriaImp implements ServicioCategoria {

    @Autowired
    RepositorioCategoria repositorioCategoria;

    @Override
    @Transactional
    public CategoriaDto categoriaNueva(@Valid CategoriaRequestDto categoriaRequestDto) {

        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequestDto.getNombre());
        categoria.setDescripcion(categoriaRequestDto.getDescripcion());
        categoria.setNivel(0);
        categoria.setSlug(categoriaRequestDto.getSlug());

        if (categoriaRequestDto.getCategoria_padre_id() != null) {

            Categoria padre = repositorioCategoria.findById(categoriaRequestDto.getCategoria_padre_id())
                    .orElseThrow(() -> new RuntimeException("El padre indicado no existe"));

            categoria.setCategoriaPadre(padre);
            categoria.setNivel(padre.getNivel() + 1);

        } else {
            categoria.setCategoriaPadre(null);
            categoria.setNivel(0);

        }

        Categoria nuevCategoria = repositorioCategoria.save(categoria);

        return new CategoriaDto(nuevCategoria.getNombre(),
                nuevCategoria.getDescripcion(), nuevCategoria.getSlug());

    }

}
