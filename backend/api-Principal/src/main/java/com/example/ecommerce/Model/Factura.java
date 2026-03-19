package com.example.ecommerce.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.utils.GeneradorCodigo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Factura {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ItemFactura> itemFactura = new ArrayList<>();
  private String numeroFactura;
  @Column(name = "fecha_emision")
  private LocalDate fechaEmision;
  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario comprador;
  @Transient
  private MedioPago metodoPago;
  @Column(name = "total_factura")
  private int total_factura;
  @ManyToOne
  @JoinColumn(name = "pedido_id")
  private Pedido pedido;

  public Factura crearFactura(Pedido pedido) {
    this.itemFactura = pedido.getItems_pedido().stream()
        .map(i -> new ItemFactura(i.getProducto(), i.getPrecioUnitario(), i.getCantidad())).toList();
    this.numeroFactura = GeneradorCodigo.generar();
    this.fechaEmision = LocalDate.now();
    this.comprador = pedido.getComprador();
    this.total_factura = pedido.getItems_pedido().stream().mapToInt(i -> i.getCantidad() * i.getPrecioUnitario()).sum();
    this.pedido = pedido;
    return this;

  }

}
