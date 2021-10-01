package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Domicilio;
import com.example.ClinicaOdontologica.entity.Odontologo;
import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.Turno;
import com.example.ClinicaOdontologica.repository.TurnoRepository;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceImplTest {

    @Autowired
    PacienteService pacienteService;
    @Autowired
    OdontologoService odontologoService;
    @Autowired
    TurnoService turnoService;

    @Test
    public void registrarTurno(){

        Paciente paciente = pacienteService.registrar(new Paciente("PacTest", "PacTest", "1234", "2021-09-21", new Domicilio("callao", "3517", "buenos aires")));
        Odontologo odontologo = odontologoService.registrar(new Odontologo("OdonTest", "OdonTest", "123456"));
        Turno turno = turnoService.registrar(new Turno(odontologo, paciente, "2019-05-12"));

        assertEquals("2019-05-12", turno.getFecha());

        assertEquals("OdonTest", turno.getOdontologo().getNombre());
        assertEquals("OdonTest", turno.getOdontologo().getApellido());

        assertEquals("PacTest", turno.getPaciente().getNombre());
        assertEquals("PacTest", turno.getPaciente().getApellido());

    }

}