package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {


    Paciente registrar(Paciente paciente);
    List<Paciente> mostrarTodos();
    Paciente modificar(Paciente paciente);
    void eliminar(Long id);
    Optional<Paciente> buscarPorId(Long id);
}
