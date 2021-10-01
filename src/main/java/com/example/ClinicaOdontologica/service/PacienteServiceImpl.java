package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public Paciente registrar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> mostrarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        if( pacienteRepository.getById(paciente.getId()) != null) {
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.delete(pacienteRepository.getById(id));
    }

    @Override
    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }
}
