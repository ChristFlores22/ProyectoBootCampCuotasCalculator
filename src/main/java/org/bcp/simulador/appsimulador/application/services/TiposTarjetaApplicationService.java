package org.bcp.simulador.appsimulador.application.services;

import org.bcp.simulador.appsimulador.persistence.entities.TiposTarjeta;

import java.util.List;

public interface TiposTarjetaApplicationService {
    List<TiposTarjeta> findAll();
    TiposTarjeta save(TiposTarjeta tipoTarjeta);
    TiposTarjeta update(Integer idTipoTarjeta, TiposTarjeta tiposTarjeta);
}
