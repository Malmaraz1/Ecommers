package com.example.ecommerce.clients;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ecommerce.Dto.StockDto;

@FeignClient(name = "servicio-control-stock", url = "${servidor.stock.url}")
public interface StockClientRest {


    @GetMapping("{idStock}")
    StockDto detalle(@PathVariable Long idStock);
    @PostMapping("stock")
    public StockDto crear(@RequestBody StockDto stockDto);

}
