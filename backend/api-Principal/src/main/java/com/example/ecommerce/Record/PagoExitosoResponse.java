package com.example.ecommerce.Record;

public record PagoExitosoResponse(
    String status,
    String mensaje,
    Long pedidoId,
    String timestamp
) {}