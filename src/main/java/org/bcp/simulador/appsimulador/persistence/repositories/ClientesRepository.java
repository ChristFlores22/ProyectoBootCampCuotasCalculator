package org.bcp.simulador.appsimulador.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.bcp.simulador.appsimulador.persistence.entities.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

}
