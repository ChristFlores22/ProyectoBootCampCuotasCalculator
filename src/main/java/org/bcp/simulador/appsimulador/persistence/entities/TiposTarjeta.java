package org.bcp.simulador.appsimulador.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TiposTarjeta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idTipoTarjeta;
    private String nombreTipoTarjeta;
}
