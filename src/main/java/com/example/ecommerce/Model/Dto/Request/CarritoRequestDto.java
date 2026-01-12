package com.example.ecommerce.Model.Dto.Request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.Model.ItemCarrito;

import com.example.ecommerce.Model.Usuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class CarritoRequestDto {
    @NotNull(message = "El ID no puede ser nulo")
    @Min(value = 1, message = "El ID debe ser un número positivo")
    private Usuario comprador;
    
    @NotEmpty(message = "no se puede realizar un pedido con el carrito vacio")
    @Valid 
    private List<ItemCarrito> itemsCarrito = new ArrayList<>();

    @PastOrPresent(message = "La fecha no puede ser futura")
    private LocalDate ultimaActualizacion;

    public CarritoRequestDto(Usuario comprador, List<ItemCarrito> itemsCarrito) {
        this.comprador = comprador;
        this.itemsCarrito = itemsCarrito;
    }

}
