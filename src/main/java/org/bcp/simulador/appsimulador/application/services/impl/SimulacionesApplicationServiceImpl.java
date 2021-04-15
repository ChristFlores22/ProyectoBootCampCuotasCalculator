package org.bcp.simulador.appsimulador.application.services.impl;

import org.apache.tomcat.jni.Local;
import org.bcp.simulador.appsimulador.application.business.QuotebusinessCase;
import org.bcp.simulador.appsimulador.application.services.SimulacionesApplicationService;
import org.bcp.simulador.appsimulador.persistence.entities.Simulaciones;
import org.bcp.simulador.appsimulador.persistence.repositories.SimulacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
public class SimulacionesApplicationServiceImpl implements SimulacionesApplicationService {
    @Autowired
    private SimulacionesRepository simulacionesRepository;


    private QuotebusinessCase quotebusinessCase = new QuotebusinessCase();

    @Override
    public List<Simulaciones> findAll(){
        return this.simulacionesRepository.findAll();
    }

    @Override
    public HashMap<String, Object> save(Simulaciones simulacion){
        simulacion.setCuotaMensual(quotebusinessCase.QuoteCFMCalculate(simulacion.getTea(),simulacion.getMontoPrestamo(),simulacion.getNumeroCuotas()));
        LocalDate Hoymas1mes = LocalDate.now().plusMonths(1);
        String monthString = (String.valueOf(Hoymas1mes.getMonthValue()).length()<2)?("0"+ String.valueOf(Hoymas1mes.getMonthValue())):(String.valueOf(Hoymas1mes.getMonthValue()));
        String diaPagoString = (simulacion.getDiaPago().toString().length()<2)?("0"+ simulacion.getDiaPago().toString()):(simulacion.getDiaPago().toString());

        LocalDate FechaPago = LocalDate.parse(Hoymas1mes.getYear() + "-" + monthString + "-" + diaPagoString);
        simulacion.setFechaPrimeraCuota(FechaPago);
        this.simulacionesRepository.save(simulacion);
        HashMap<String, Object> map = new HashMap<>();
        map.put("cuota",simulacion.getCuotaMensual());
        map.put("moneda", simulacion.getMonedaSimulacion());
        map.put("primeraCuota", simulacion.getFechaPrimeraCuota());
        map.put("estado", "exitoso");
        return map;
    }

//    @Override
//    public Simulaciones update(Integer simulacionId, Simulaciones simulacion) {
//        return null;
//    }


}
