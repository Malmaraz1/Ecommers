package com.example.ecommerce.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Carrito {

   private Usuario comprador;
   private List<ItemCarrito> itemsCarrito = new ArrayList<>();
   private LocalDate ultimaActualizacion;
   private Pedido pedido;

   public void agregarItem(Producto producto, int Cantidad) {

      Optional<ItemCarrito> existente = itemsCarrito.stream().filter(i -> i.getProducto().equals(producto)).findFirst();
      if (existente.isPresent()) {
         existente.get().setCantidad(Cantidad);
      } else {
         itemsCarrito.add(new ItemCarrito(Cantidad, producto.getPrecio(), producto));
      }
   }

   public Pedido ConfirmarPedido() {
      if (itemsCarrito.isEmpty())
         throw new RuntimeException("Carrito vacio");
      return new Pedido(this);
   }

}
