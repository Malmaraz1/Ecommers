package com.example.ecommerce.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrdenCompra {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="numero_orden")
  private String numeroDeOrden;
  @Column(name="fecha_creacion")
  private LocalDate fechaCreacion;
  @ManyToOne
  @JoinColumn(name="usuario_final_id")
  private Usuario comprador;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "orden_id")
  private List<ItemOrden> items = new ArrayList<>();
  @Column(name="sub_total")
  private Double subTotal;
  @Column(name="total")
  private Double total;

  public OrdenCompra(String numeroDeOrden, List<ItemOrden> itemCarritos, Usuario comprador) {
    this.numeroDeOrden = numeroDeOrden;
    this.fechaCreacion = LocalDate.now();
    this.comprador = comprador;

    this.items = itemCarritos.stream()
        .map(ic -> new ItemOrden(
            ic.getProducto(),
            ic.getPrecio(),
            ic.getCantidad()))
        .toList();

    this.subTotal = items.stream()
        .mapToDouble(ItemOrden::getSubtotal)
        .sum();

    this.total = this.subTotal;
  }
}
