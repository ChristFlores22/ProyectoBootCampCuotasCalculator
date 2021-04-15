package org.bcp.simulador.appsimulador.application.services;

import org.bcp.simulador.appsimulador.persistence.entities.Clientes;

import java.util.List;

public interface ClientesApplicationService {
    List<Clientes> findAll();
    Clientes save(Clientes cliente);
    Clientes update(Integer idCliente, Clientes cliente);

}
