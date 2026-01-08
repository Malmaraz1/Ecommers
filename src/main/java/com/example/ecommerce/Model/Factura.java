package com.example.ecommerce.Model;

import java.time.LocalDate;

public class Factura {
  private OrdenCompra ordenCompra;
  private String numeroFactura;
  private LocalDate fechaEmision;
  private String comprador;
  private String vendedor;
  private MedioPago metodoPago;
  
  
  public Factura (String numeroFactura, Comprador comprador,
      Vendedor vendedor) {
    this.numeroFactura = numeroFactura;
    this.fechaEmision = LocalDate.now();
    this.comprador = comprador.getNombre();
    this.vendedor = vendedor.getNombre();
  }

    

}
