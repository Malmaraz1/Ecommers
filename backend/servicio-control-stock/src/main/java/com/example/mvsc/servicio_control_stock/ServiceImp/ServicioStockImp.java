package com.example.mvsc.servicio_control_stock.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

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
                                ? requestStock.getPunto_reposicion()
                                : 1000;
                Integer cantidad = (requestStock.getStock_maximo() != null)
                                ? requestStock.getPunto_reposicion()
                                : 50;

                Stock stock = new Stock(deposito, requestStock.getProducto_id(),
                                cantidad, puntoReposition,
                                stockmMaximo,
                                requestStock.getDetalle(), requestStock.getProxima_reposicion());

                Stock stockNuevo = repositorioStock.save(stock);

                return new StockDto(stockNuevo.getId(), deposito.getId(),
                                requestStock.getProducto_id(),
                                requestStock.getCantidad(), requestStock.getPunto_reposicion(),
                                requestStock.getStock_maximo(),
                                requestStock.getDetalle(), requestStock.getProxima_reposicion());

        }

        @Override
        public StockDto detalle(Long idStock) {

                Stock stockNuevo = repositorioStock.findById(idStock).orElseThrow(
                                () -> new NotFoundException("no se encontro el stock con id " + idStock));

                return new StockDto(stockNuevo.getId(), stockNuevo.getDeposito().getId(),
                                stockNuevo.getProducto_id(),
                                stockNuevo.getCantidad(), stockNuevo.getPunto_reposicion(),
                                stockNuevo.getStock_maximo(),
                                stockNuevo.getDetalle(), stockNuevo.getProxima_reposicion());

        }

}
