package com.example.mvsc.servicio_control_stock.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvsc.servicio_control_stock.Dto.DepositoDto;
import com.example.mvsc.servicio_control_stock.Model.DatosContacto;
import com.example.mvsc.servicio_control_stock.Model.Deposito;
import com.example.mvsc.servicio_control_stock.Repository.RepositorioDeposito;
import com.example.mvsc.servicio_control_stock.Service.ServicioDeposito;
@Service
public class ServicioDepositoImp implements ServicioDeposito {

    @Autowired
    RepositorioDeposito repositorioDeposito;

    @Override
    public DepositoDto crearDeposito(Deposito deposito) {

        DatosContacto datosContacto = new DatosContacto(deposito.getDatosContacto().getDomicilio(),
                deposito.getDatosContacto().getTelefono(), deposito.getDatosContacto().getZona());

        Deposito depositoNuevo = new Deposito(deposito.getDetalle(), datosContacto);

        Deposito depositoDb = repositorioDeposito.save(depositoNuevo);
        System.out.print("Esta es la id del deposito" + depositoDb.getId());
        return new DepositoDto(depositoDb.getId(), depositoDb.getDetalle(), depositoDb.getDatosContacto());

    }

}
