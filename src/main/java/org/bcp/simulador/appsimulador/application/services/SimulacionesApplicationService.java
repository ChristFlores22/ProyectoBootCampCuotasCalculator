package org.bcp.simulador.appsimulador.application.services;

import org.bcp.simulador.appsimulador.persistence.entities.Simulaciones;

import java.util.HashMap;
import java.util.List;

public interface SimulacionesApplicationService {
    List<Simulaciones> findAll();
    HashMap<String, Object> save(Simulaciones simulacion);
   // Simulaciones update(Integer simulacionId, Simulaciones simulacion);
}
