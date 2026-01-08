package com.example.ecommerce.Model;

public class PagarCommand implements Command {
    private Pedido pedido;
    private MedioPago medioPago;
    private AdapterPdf adapterPdf;

    @Override
    public void ejecutar() {
        medioPago.procesarPago();;
        adapterPdf.generarFactura();
        pedido.setEstadoPedido(new Envio());

    }

}
