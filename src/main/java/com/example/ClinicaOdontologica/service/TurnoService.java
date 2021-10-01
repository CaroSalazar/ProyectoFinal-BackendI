package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoService {

    Turno registrar(Turno turno);

    List<Turno> mostrarTodos();

    Turno modificar(Turno turno);

    void eliminar(Long id);

    Optional<Turno> buscarPorId(Long id);
}