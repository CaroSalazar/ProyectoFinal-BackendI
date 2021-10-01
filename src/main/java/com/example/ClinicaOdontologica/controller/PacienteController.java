package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteController {

    private Logger logger = Logger.getLogger("It's-a me, Mario!");

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/")
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente) {
        logger.info("Registrando paciente nuevo");
        return ResponseEntity.ok(pacienteService.registrar(paciente));
    }

    @PutMapping("/")
    public ResponseEntity<Paciente> modificar(@RequestBody Paciente paciente) {
        if (pacienteService.buscarPorId(paciente.getId()).isPresent()) {
            logger.info("Modificando paciente existente");
            pacienteService.registrar(paciente);
            return ResponseEntity.ok(paciente);
        }
        logger.info("Falló la petición o el paciente no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> buscarPorId(@PathVariable Long id) {
        if (id != null) {
            logger.info("Consultando paciente particular");
            return ResponseEntity.ok(pacienteService.buscarPorId(id));
        }
        logger.info("Falló la petición o el paciente no existe");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Paciente>> mostrarTodos() {
        logger.info("Consultando pacientes");
        return ResponseEntity.ok(pacienteService.mostrarTodos());
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(pacienteService.buscarPorId(id).isPresent()){
            logger.info("Borrando paciente particular");
            pacienteService.eliminar(id);
            return "El paciente con id " + id + " se ha eliminado con éxito ";
        }
        logger.info("Falló la petición o el paciente no existe");
        return "No se encontró ningún paciente con id " + id;
    }

}
