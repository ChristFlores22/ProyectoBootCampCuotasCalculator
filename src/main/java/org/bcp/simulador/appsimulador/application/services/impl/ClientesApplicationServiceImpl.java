package org.bcp.simulador.appsimulador.application.services.impl;


import org.bcp.simulador.appsimulador.application.services.ClientesApplicationService;
import org.bcp.simulador.appsimulador.persistence.entities.Clientes;
import org.bcp.simulador.appsimulador.persistence.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesApplicationServiceImpl implements ClientesApplicationService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    public List<Clientes> findAll(){
        return  this.clientesRepository.findAll();
    }
    @Override
    public Clientes save(Clientes cliente){

        return this.clientesRepository.save(cliente);
    }

    @Override
    public Clientes update(Integer clienteId, Clientes cliente){
        var clienteSaved = this.clientesRepository.findById(clienteId);
        if (clienteSaved.isPresent()){
            cliente.setIdCliente(clienteId);
            return this.clientesRepository.save(cliente);
        }
        return null;
    }
}
