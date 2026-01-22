package com.example.ecommerce.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
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
    @OneToMany(mappedBy = "categoriaPadre", cascade = CascadeType.ALL)
    private List<Categoria> subCategorias = new ArrayList<>();
    @Column(name="nivel")
    private Integer nivel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_padre_id") 
    private Categoria categoriaPadre;
  
   
    
    
    public Categoria(String nombre, String slug, String descripcion , Integer nivel) {
        this.nombre = nombre;
        this.slug = slug;
        this.descripcion = descripcion;
        this.nivel = nivel;
    }
    public boolean esHojaPadre() {
    return subCategorias == null || subCategorias.isEmpty();
    
}

public void agregarSubcategoria(Categoria sub) {
        subCategorias.add(sub);
        
    }
}



   

    

