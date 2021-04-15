package org.bcp.simulador.appsimulador.web.controllers;

import org.bcp.simulador.appsimulador.application.services.ClientesApplicationService;
import org.bcp.simulador.appsimulador.persistence.entities.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClientesController {
    @Autowired
    private ClientesApplicationService clientesApplicationService;

    @GetMapping
    public List<Clientes> findAll(){
        List<Clientes> CliList = this.clientesApplicationService.findAll();
        return CliList;
    }

    @PostMapping
    public Clientes save(@RequestBody Clientes cliente){
        System.out.println("Cliente : " + cliente);
        return this.clientesApplicationService.save(cliente);
    }

    @PutMapping("/{idCliente}")
    public Clientes update( @PathVariable("idCliente") Integer clienteId, @RequestBody Clientes cliente){
        return this.clientesApplicationService.update(clienteId,cliente);
    }

}
