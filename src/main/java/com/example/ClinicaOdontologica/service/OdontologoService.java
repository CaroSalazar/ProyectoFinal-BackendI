package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface OdontologoService {

    Odontologo registrar(Odontologo odontologo);
    List<Odontologo> mostrarTodos();
    Odontologo modificar(Odontologo odontologo);
    void eliminar(Long id);
    Optional<Odontologo> buscarPorId(Long id);
}