package org.bcp.simulador.appsimulador.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Simulaciones {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idSimulacion;

    @NotNull(message ="El campo idTipoTarjeta no puede ser Nulo")
    private Integer idTipoTarjeta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="idCliente", referencedColumnName = "idCliente", nullable = false)
    @JsonBackReference
    private Clientes cliente;


    @NotNull(message = "El campo tea no puede ser Nulo")
    @Digits(integer = 2,fraction = 2, message = "Formato invalido para la TEA, solo se admiten 2 enteros y 2 decimales")
    private Double tea;

    @NotNull(message = "El campo diaPago no puede ser Nulo")
    @Min(value = 5,message = "El día de pago solo puede ser  5 o 20")
    @Max(value = 20,message = "El día de pago solo puede ser  5 o 20")
    private Integer diaPago;

    @NotNull(message = "El campo montoPrestamos no puede ser Nulo")
    @Min(value = 1000,message = "Solo se admite Prestamos entre 1000 y 25000")
    @Max(value = 25000,message = "Solo se admite Prestamos entre 1000 y 25000")
    private Double montoPrestamo;


    @Size(min = 1, max = 3,message = "Solo se admite S/. o $")
    private String monedaSimulacion;
    @NotNull(message ="El campo numeroCuotas no puede ser Nulo")
    @Min(value = 1, message = "Solo se admite Cuotas entre 1 y 36")
    @Max(value = 36, message = "Solo se admite Cuotas entre 1 y 36")
    private Integer numeroCuotas;


    private Double cuotaMensual;
    private LocalDate fechaPrimeraCuota;

}
