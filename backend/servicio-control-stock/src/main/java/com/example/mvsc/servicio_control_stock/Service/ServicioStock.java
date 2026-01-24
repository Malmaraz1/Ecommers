package com.example.mvsc.servicio_control_stock.Service;



import com.example.mvsc.servicio_control_stock.Dto.StockDto;
import com.example.mvsc.servicio_control_stock.Dto.RequestDto.RequestStock;

public interface ServicioStock {

    StockDto crearStock(RequestStock requestStock);
    StockDto detalle(Long idStock );
    
}
