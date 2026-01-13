package com.example.ecommerce.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.Model.Categoria;
import com.example.ecommerce.Model.Dto.Request.CategoriaRequestDto;
import com.example.ecommerce.Repository.RepositorioCategoria;
import com.example.ecommerce.Service.ServiceImp.ServicioCategoriaImp;

import jakarta.validation.Valid;

@Service
public class ServicioCategoria implements ServicioCategoriaImp {

    @Autowired
    RepositorioCategoria repositorioCategoria;

    @Override
    @Transactional
    public Categoria categoriaNueva(@Valid CategoriaRequestDto categoriaRequestDto) {

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

        return nuevCategoria;

    }

}
