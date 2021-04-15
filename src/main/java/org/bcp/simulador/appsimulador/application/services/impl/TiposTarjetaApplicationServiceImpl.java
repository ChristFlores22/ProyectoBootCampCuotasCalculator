package org.bcp.simulador.appsimulador.application.services.impl;

import org.bcp.simulador.appsimulador.application.services.TiposTarjetaApplicationService;
import org.bcp.simulador.appsimulador.persistence.entities.TiposTarjeta;
import org.bcp.simulador.appsimulador.persistence.repositories.TiposTarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class TiposTarjetaApplicationServiceImpl implements TiposTarjetaApplicationService {
    @Autowired
    private TiposTarjetaRepository tiposTarjetaRepository;

    @Override
    public List<TiposTarjeta> findAll(){
        return this.tiposTarjetaRepository.findAll();
    }

    @Override
    public TiposTarjeta save(TiposTarjeta tipoTarjeta){
        return this.tiposTarjetaRepository.save(tipoTarjeta);
    }

    @Override
    public TiposTarjeta update(Integer tipoTarjetaId, TiposTarjeta tipoTarjeta) {
        var tipoTarjetaSaved = this.tiposTarjetaRepository.findById(tipoTarjetaId);
        if (tipoTarjetaSaved.isPresent()){
            tipoTarjeta.setIdTipoTarjeta(tipoTarjetaId);
            return this.tiposTarjetaRepository.save(tipoTarjeta);
        }
        return null;
    }
}
