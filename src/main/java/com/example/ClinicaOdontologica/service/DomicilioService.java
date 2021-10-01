package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Domicilio;

import java.util.List;
import java.util.Optional;

public interface DomicilioService {

    Domicilio registrar(Domicilio domicilio);
    List<Domicilio> mostrarTodos();
    Domicilio modificar(Domicilio domicilio);
    void eliminar(Long id);
    Optional<Domicilio> buscarPorId(Long id);
}
