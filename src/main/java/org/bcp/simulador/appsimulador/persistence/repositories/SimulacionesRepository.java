package org.bcp.simulador.appsimulador.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.bcp.simulador.appsimulador.persistence.entities.Simulaciones;

public interface SimulacionesRepository extends JpaRepository<Simulaciones, Integer> {
}
