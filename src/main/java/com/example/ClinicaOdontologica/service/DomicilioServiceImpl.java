package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Domicilio;
import com.example.ClinicaOdontologica.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements DomicilioService{

    @Autowired
    DomicilioRepository domicilioRepository;

    @Override
    public Domicilio registrar(Domicilio domicilio) {
        if(domicilio != null){
            return domicilioRepository.save(domicilio);
        }
        return null;
    }

    @Override
    public List<Domicilio> mostrarTodos() {
        return domicilioRepository.findAll();
    }


    @Override
    public Domicilio modificar(Domicilio domicilio) {
        if(domicilioRepository.getById(domicilio.getId()) != null) {
            return domicilioRepository.save(domicilio);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        domicilioRepository.delete(domicilioRepository.getById(id));
    }

    @Override
    public Optional<Domicilio> buscarPorId(Long id) {
        return domicilioRepository.findById(id);
    }
}
