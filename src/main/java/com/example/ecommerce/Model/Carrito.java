package com.example.ecommerce.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity(name = "carrito")
public class Carrito {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ManyToOne
   @JoinColumn(name = "usuario_id")
   private Usuario comprador;
   @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<ItemCarrito> itemsCarrito = new ArrayList<>();
   @Column(name = "ultima_actualizacion")
   private LocalDate ultimaActualizacion;

   public Carrito(Usuario comprador) {
      this.comprador = comprador;
   }

   public void agregarItem(Producto producto, Integer cantidad) {
      Optional<ItemCarrito> existente = itemsCarrito.stream().filter(i -> i.getProducto().equals(producto)).findFirst();
      if (existente.isPresent()) {
         ItemCarrito item = existente.get();
         item.setCantidad(item.getCantidad() + cantidad);

      } else {
         ItemCarrito itemCarrito = new ItemCarrito(cantidad, producto.getPrecio(), producto);
         itemsCarrito.add(itemCarrito);
         itemCarrito.setCarrito(this);

      }
   }
    public void quitarItem(Producto producto, Integer cantidad) {
      Optional<ItemCarrito> existente = itemsCarrito.stream().filter(i -> i.getProducto().equals(producto)).findFirst();
      if (existente.isPresent()) {
         ItemCarrito item = existente.get();
         item.setCantidad(item.getCantidad() - cantidad);

      } else {
         ItemCarrito itemCarrito = new ItemCarrito(cantidad, producto.getPrecio(), producto);
         itemsCarrito.add(itemCarrito);
         itemCarrito.setCarrito(this);

      }
   }
   

}
