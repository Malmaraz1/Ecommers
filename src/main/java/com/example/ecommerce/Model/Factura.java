package com.example.ecommerce.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

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
  @ManyToOne
  @JoinColumn(name="orden_compra_id")
  private OrdenCompra ordenCompra;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "item_factura_id")
  private List<ItemFactura> itemFactura = new ArrayList<>();
  private String numeroFactura;
  @Column(name="fecha_emision")
  private LocalDate fechaEmision;
  @ManyToOne
  @JoinColumn(name="usuario_id")
  private Usuario comprador;
  @Transient
  private MedioPago metodoPago;
  
  
  
  public Factura (String numeroFactura, Comprador comprador,
      Vendedor vendedor) {
    this.numeroFactura = numeroFactura;
    this.fechaEmision = LocalDate.now();
    this.comprador = comprador;
  }

    

}
