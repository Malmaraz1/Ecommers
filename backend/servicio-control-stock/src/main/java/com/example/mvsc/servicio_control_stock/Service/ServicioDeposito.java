package com.example.mvsc.servicio_control_stock.Service;

import com.example.mvsc.servicio_control_stock.Dto.DepositoDto;
import com.example.mvsc.servicio_control_stock.Model.Deposito;


public interface ServicioDeposito {
    DepositoDto crearDeposito(Deposito deposito);
}
