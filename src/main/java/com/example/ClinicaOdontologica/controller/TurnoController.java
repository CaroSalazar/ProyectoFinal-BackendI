package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Turno;
import com.example.ClinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/turnos")
@CrossOrigin("*")
public class TurnoController {

    private Logger logger = Logger.getLogger("It's-a me, Mario!");

    @Autowired
    TurnoService turnoService;

    @PostMapping("/")
    public ResponseEntity<Turno> registrar(@RequestBody Turno turno) {
        logger.info("Registrando turno nuevo");
        return ResponseEntity.ok(turnoService.registrar(turno));
    }

    @PutMapping("/")
    public ResponseEntity<Turno> modificar(@RequestBody Turno turno) {
        if (turnoService.buscarPorId(turno.getId()).isPresent()) {
            logger.info("Modificando turno existente");
            turnoService.registrar(turno);
            return ResponseEntity.ok(turno);
        }
        logger.info("Falló la petición o el turno no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turno>> buscarPorId(@PathVariable Long id) {
        if (id != null) {
            logger.info("Consultando turno particular");
            return ResponseEntity.ok(turnoService.buscarPorId(id));
        }
        logger.info("Falló la petición o el turno no existe");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Turno>> mostrarTodos() {
        logger.info("Consultando turnos");
        return ResponseEntity.ok(turnoService.mostrarTodos());
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(turnoService.buscarPorId(id).isPresent()){
            logger.info("Borrando turno particular");
            turnoService.eliminar(id);
            return "El turno con id " + id + " se ha eliminado con éxito ";
        }
        logger.info("Falló la petición o el turno no existe");
        return "No se encontro ningún turno con id " + id;
    }

}