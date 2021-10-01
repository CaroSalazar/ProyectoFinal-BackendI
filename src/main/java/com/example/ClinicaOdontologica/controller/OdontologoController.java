package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Odontologo;
import com.example.ClinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/odontologos")
@CrossOrigin("*")
public class OdontologoController {

    private Logger logger = Logger.getLogger("It's-a me, Mario!");
    @Autowired
    OdontologoService odontologoService;

    @PostMapping("/")
    public ResponseEntity<Odontologo> registrar(@RequestBody Odontologo odontologo) {
        logger.info("Registrando odontólogo nuevo");
        return ResponseEntity.ok(odontologoService.registrar(odontologo));
    }

    @PutMapping("/")
    public ResponseEntity<Odontologo> modificar(@RequestBody Odontologo odontologo) {
        if (odontologoService.buscarPorId(odontologo.getId()).isPresent()) {
            logger.info("Modificando odontólogo existente");
            odontologoService.registrar(odontologo);
            return ResponseEntity.ok(odontologo);
        }
        logger.info("Falló la petición o el odontólogo no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Odontologo>> buscarPorId(@PathVariable Long id) {
        if (id != null) {
            logger.info("Consultando odontólogo particular");
            return ResponseEntity.ok(odontologoService.buscarPorId(id));
        }
        logger.info("Falló la petición o el odontologo no existe");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Odontologo>> mostrarTodos() {
        logger.info("Consultando odontólogos");
        return ResponseEntity.ok(odontologoService.mostrarTodos());
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(odontologoService.buscarPorId(id).isPresent()){
            logger.info("Borrando odontólogo particular");
            odontologoService.eliminar(id);
            return "El odontólogo con id " + id + " se ha eliminado con éxito ";
        }
        logger.info("Falló la petición o el odontólogo no existe");
        return "No se encontro ningún odontologo con id " + id;
    }

}
