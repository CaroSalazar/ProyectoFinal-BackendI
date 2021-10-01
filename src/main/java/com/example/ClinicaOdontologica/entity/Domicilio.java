package com.example.ClinicaOdontologica.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name="domicilios")
@Entity
@Getter
@Setter
@ToString
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private String numero;
    private String provincia;

    public Domicilio(String calle, String numero, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.provincia = provincia;
    }

    public Domicilio() {
    }
}