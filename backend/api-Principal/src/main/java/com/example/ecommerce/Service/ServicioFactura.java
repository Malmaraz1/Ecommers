package com.example.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.Dto.FacturaDto;
import com.example.ecommerce.Model.Factura;
import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Repository.RepositorioFactura;
@Service
public class ServicioFactura {

    @Autowired
    RepositorioFactura repositorioFactura;

    @Transactional
    public void guardarFactura(Pedido pedido) {

        Factura factura = new Factura();
        factura.crearFactura(pedido);
        repositorioFactura.save(factura);
    }

    @Transactional(readOnly = true)
    public FacturaDto facturaActual(Long facturaId) {

        Factura factura = repositorioFactura.findById(facturaId).orElseThrow();

        FacturaDto facturaDto = new FacturaDto();
        facturaDto.setComprador(factura.getComprador());
        facturaDto.setFechaEmision(factura.getFechaEmision());
        facturaDto.setId(facturaId);
        facturaDto.setNumeroFactura(factura.getNumeroFactura());
        facturaDto.setPedido(factura.getPedido());
        facturaDto.setTotal_factura(factura.getTotal_factura());
        return facturaDto;

    }

}
