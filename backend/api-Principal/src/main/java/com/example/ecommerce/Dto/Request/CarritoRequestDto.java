package com.example.ecommerce.Dto.Request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.Model.ItemCarrito;



import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CarritoRequestDto {
    @NotNull(message = "El ID no puede ser nulo")
    @Min(value = 1, message = "El ID debe ser un número positivo")
    private Long usuario_id;
    
    @NotEmpty(message = "no se puede realizar un pedido con el carrito vacio")
    @Valid 
    private List<ItemCarrito> itemsCarrito = new ArrayList<>();

    @PastOrPresent(message = "La fecha no puede ser futura")
    private LocalDate ultimaActualizacion;

    public CarritoRequestDto(Long usuario_id, List<ItemCarrito> itemsCarrito) {
        this.usuario_id = usuario_id;
        this.itemsCarrito = itemsCarrito;
    }

}
