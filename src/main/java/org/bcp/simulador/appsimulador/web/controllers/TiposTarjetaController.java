package org.bcp.simulador.appsimulador.web.controllers;

import org.bcp.simulador.appsimulador.application.services.TiposTarjetaApplicationService;
import org.bcp.simulador.appsimulador.persistence.entities.TiposTarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tiposTarjeta")
public class TiposTarjetaController {
    @Autowired
    TiposTarjetaApplicationService tiposTarjetaApplicationService;

    @GetMapping
    public List<TiposTarjeta> findAll(){
        return tiposTarjetaApplicationService.findAll();
    }

    @PostMapping
    public TiposTarjeta save(@RequestBody TiposTarjeta tipoTarjeta){
        return this.tiposTarjetaApplicationService.save(tipoTarjeta);
    }

    @PutMapping("/{idTipoTarjeta}")
    public TiposTarjeta update(@PathVariable("idTipoTarjeta") Integer tipoTarjetaId, @RequestBody TiposTarjeta tipoTarjeta){
        return this.tiposTarjetaApplicationService.update(tipoTarjetaId,tipoTarjeta);
    }

}
