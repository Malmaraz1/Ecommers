package com.example.ecommerce.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Categoria {
    private String nombre;
    private String slug;
    private String descripcion;
    private List<Categoria> subCategorias = new ArrayList<>();
    private Integer nivel;
    private List<Producto> productos = new ArrayList<>();
    
    
    public Categoria(String nombre, String slug, String descripcion, List<Categoria> subCategorias, Integer nivel) {
        this.nombre = nombre;
        this.slug = slug;
        this.descripcion = descripcion;
        this.subCategorias = subCategorias;
        this.nivel = nivel;
    }
    public boolean esHojaPadre() {
    return subCategorias == null || subCategorias.isEmpty();
    
}



   

    

}