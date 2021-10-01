package com.example.ClinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "odontologos")
@Getter
@Setter
@ToString

public class Odontologo {

    @Id
    @GeneratedValue

    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    @JsonIgnore
    @OneToMany(mappedBy = "odontologo")
    private Set<Turno> turnos;

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Odontologo() {

    }
}
