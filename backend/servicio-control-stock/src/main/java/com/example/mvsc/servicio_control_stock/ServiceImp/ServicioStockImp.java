package com.example.mvsc.servicio_control_stock.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvsc.servicio_control_stock.Dto.StockDto;
import com.example.mvsc.servicio_control_stock.Dto.RequestDto.RequestStock;
import com.example.mvsc.servicio_control_stock.Exception.NotFoundException;
import com.example.mvsc.servicio_control_stock.Model.Deposito;
import com.example.mvsc.servicio_control_stock.Model.Stock;
import com.example.mvsc.servicio_control_stock.Repository.RepositorioDeposito;
import com.example.mvsc.servicio_control_stock.Repository.RepositorioStock;
import com.example.mvsc.servicio_control_stock.Service.ServicioStock;

@Service
public class ServicioStockImp implements ServicioStock {

        @Autowired
        RepositorioDeposito repositorioDeposito;
        @Autowired
        RepositorioStock repositorioStock;

        @Override
        public StockDto crearStock(RequestStock requestStock) {

                Deposito deposito = repositorioDeposito.findById(requestStock.getDeposito_id())
                                .orElseThrow(() -> new NotFoundException("no se encontro un deposito con id" +
                                                requestStock.getDeposito_id()));

                Integer puntoReposition = (requestStock.getPunto_reposicion() != null)
                                ? requestStock.getPunto_reposicion()
                                : 500;
                Integer stockmMaximo = (requestStock.getStock_maximo() != null)
                                ? requestStock.getStock_maximo()
                                : 1000;
                Integer cantidad = (requestStock.getCantidad()!= null)
                                ? requestStock.getCantidad()
                                : 50;

                Stock stock = new Stock(deposito, requestStock.getProducto_id(),
                                cantidad, puntoReposition,
                                stockmMaximo,
                                requestStock.getDetalle(), requestStock.getProxima_reposicion());

                Stock stockDetalle = repositorioStock.save(stock);

                return new StockDto(stockDetalle.getId(), deposito.getId(),
                                requestStock.getProducto_id(),
                                requestStock.getCantidad(), requestStock.getPunto_reposicion(),
                                requestStock.getStock_maximo(),
                                requestStock.getDetalle(), requestStock.getProxima_reposicion());

        }

        @Override
        @Transactional(readOnly = true)
        public StockDto detalle(Long producto_id) {
                
                Stock stockDetalle = repositorioStock.findByProductoId(producto_id).orElseThrow(
                                () -> new NotFoundException("no se encontro el stock para el producto con id " + producto_id));
                
                return new StockDto(stockDetalle.getId(), stockDetalle.getDeposito().getId(),
                                stockDetalle.getProductoId(),
                                stockDetalle.getCantidad(), stockDetalle.getPunto_reposicion(),
                                stockDetalle.getStock_maximo(),
                                stockDetalle.getDetalle(), stockDetalle.getProxima_reposicion());

        }

}
