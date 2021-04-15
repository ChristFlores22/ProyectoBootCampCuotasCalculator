package org.bcp.simulador.appsimulador.web.controllers;

import org.bcp.simulador.appsimulador.application.services.ClientesApplicationService;

import org.bcp.simulador.appsimulador.application.services.SimulacionesApplicationService;
import org.bcp.simulador.appsimulador.persistence.entities.Simulaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("simulaciones")
public class SimulacionesController {
    @Autowired
    private SimulacionesApplicationService simulacionesApplicationService;

    @GetMapping
    public List<Simulaciones> findAll(){
        return this.simulacionesApplicationService.findAll();
    }

    @PostMapping
    public HashMap<String, Object> save(@Valid @RequestBody Simulaciones simulacion){
        System.out.println("Simulacion : " + simulacion);
        return this.simulacionesApplicationService.save(simulacion);
    }

  /*  @PutMapping("/{idSimulacion}")
    public Simulaciones update(@PathVariable("idSimulacion") Integer simulacionId, @RequestBody Simulaciones simulacion){
        return this.simulacionesApplicationService.update(simulacionId,simulacion);
    }*/
}
