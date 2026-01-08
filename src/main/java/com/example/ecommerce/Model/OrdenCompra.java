package com.example.ecommerce.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdenCompra {
  private String numeroDeOrden;
  private LocalDate fechaCreacion;
  private Usuario vendedor;
  private Usuario comprado;
  private List<ItemOrden> itemOrden = new ArrayList<>();
  private Integer cantidad;
  private Double subTotal;
  private Integer descuento;
  private Double total;
  private DatosFinancieros datosFinancieros;
  private Logistica logistica;

  public OrdenCompra(String numeroDeOrden, List<ItemCarrito> itemCarritos) {
    this.numeroDeOrden = numeroDeOrden;
    this.itemOrden = itemCarritos.stream()
        .map(itemCarrito -> new ItemOrden(itemCarrito.getProducto(),
            itemCarrito.getPrecioUnitario()))
        .toList();
    this.cantidad = itemCarritos.size();
    this.total = itemOrden.stream().mapToDouble(itemOrden -> itemOrden.getSubtotal()).sum();
    this.subTotal = itemOrden.stream()
                     .mapToDouble(item -> item.getSubtotal())
                     .sum();
  }

}
