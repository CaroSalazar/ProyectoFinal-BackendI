package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Odontologo;
import com.example.ClinicaOdontologica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements OdontologoService{

    @Autowired
    OdontologoRepository odontologoRepository;

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        if(odontologo != null){
            return odontologoRepository.save(odontologo);
        }
        return null;
    }

    @Override
    public List<Odontologo> mostrarTodos() {
        return  odontologoRepository.findAll();
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        if(odontologoRepository.getById(odontologo.getId()) != null) {
            return odontologoRepository.save(odontologo);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        odontologoRepository.delete(odontologoRepository.getById(id));
    }

    @Override
    public Optional<Odontologo> buscarPorId(Long id) {
        return odontologoRepository.findById(id);
    }
}
