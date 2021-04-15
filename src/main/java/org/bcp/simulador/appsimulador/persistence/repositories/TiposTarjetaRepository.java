package org.bcp.simulador.appsimulador.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.bcp.simulador.appsimulador.persistence.entities.TiposTarjeta;

public interface TiposTarjetaRepository extends JpaRepository<TiposTarjeta,Integer> {
}
