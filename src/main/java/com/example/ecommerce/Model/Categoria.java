package com.example.ecommerce.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name="categoria")
public class Categoria {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="slug")
    private String slug;
    @Column(name="descripcion")
    private String descripcion;
    @OneToMany
    @JoinColumn(name = "categoria_id")
    private List<Categoria> subCategorias = new ArrayList<>();
    @Column(name="nivel")
    private Integer nivel;
    @ManyToOne(fetch = FetchType.LAZY)
    @OneToMany
    @JoinColumn(name = "producto_id")
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

public void agregarSubcategoria(Categoria sub) {
        subCategorias.add(sub);
        
    }



   

    

};