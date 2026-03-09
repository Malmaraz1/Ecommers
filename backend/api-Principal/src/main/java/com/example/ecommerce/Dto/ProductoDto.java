package com.example.ecommerce.Dto;

import com.example.ecommerce.Dto.Request.ProductoRequestDto;
import com.example.ecommerce.Model.Producto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class ProductoDto {
    private Long id;
    private String nombre;
    private String modelo;
    private Double precio;
    private String descripcion;
    private Long categoria_id;
    private Integer cantidad;
    private String img;
    private String marca;

    public ProductoDto(Producto p) {
        this.id = p.getId();
        this.nombre = p.getNombre();
        this.modelo = p.getModelo();
        this.precio = p.getPrecio();
        this.descripcion = p.getDescripcion_productro();
        this.categoria_id = p.getCategoria().getId();
        this.img = p.getImagen();
        this.marca = p.getMarca();

    }

    public ProductoDto() {
    }
    

    
}
