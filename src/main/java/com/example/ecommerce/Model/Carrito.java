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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="carrito")
public class Carrito {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ManyToOne
   @JoinColumn(name="usuario_id")
   private Usuario comprador;
   @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<ItemCarrito> itemsCarrito = new ArrayList<>();
   @Column(name="ultima_actualizacion")
   private LocalDate ultimaActualizacion;
   @ManyToOne
   @JoinColumn(name="pedido_id")
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
