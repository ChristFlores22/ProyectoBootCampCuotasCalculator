package org.bcp.simulador.appsimulador.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Clientes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCliente;

    @NotNull(message = "El Apellido no puede ser Nulo")
    @Pattern(regexp = "^[a-zA-Z]+$",message = "El nombre solo debe contener letras")
    private String nombreCliente;

    @NotNull(message = "El Apellido no puede ser Nulo")
    @Pattern(regexp = "^[a-zA-Z]+$",message = "El Apellido solo debe contener letras")
    private String apellidoCliente;

    @Column(unique = true)
    @Size(min = 8, max = 8, message = "Solo debe contener 8 digitos.")
    @NotNull(message = "El DNI no puede ser Nulo")
    private String DNI;

    @OneToMany(mappedBy = "cliente",orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Simulaciones> ListaSimulaciones;
}
