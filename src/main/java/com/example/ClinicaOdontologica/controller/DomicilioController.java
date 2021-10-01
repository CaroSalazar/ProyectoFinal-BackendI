package com.example.ClinicaOdontologica.controller;


import com.example.ClinicaOdontologica.entity.Domicilio;
import com.example.ClinicaOdontologica.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/domicilios")
@CrossOrigin("*")
public class DomicilioController {

    @Autowired
    DomicilioService domicilioService;
    private Logger logger = Logger.getLogger("It's-a me, Mario!");

    @PostMapping("/")
    public ResponseEntity<Domicilio> registrar(@RequestBody Domicilio domicilio) {
        logger.info("Registrando nuevo domicilio");
        return ResponseEntity.ok(domicilioService.registrar(domicilio));
    }

    @PutMapping("/")
    public ResponseEntity<Domicilio> modificar(@RequestBody Domicilio domicilio) {
        if (domicilioService.buscarPorId(domicilio.getId()).isPresent()) {
            logger.info("Modificando domicilio existente");
            domicilioService.registrar(domicilio);
            return ResponseEntity.ok(domicilio);
        }
        logger.info("Falló la petición o el domicilio no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> buscarPorId(@RequestBody Domicilio domicilio){
        if (domicilioService.buscarPorId(domicilio.getId()).isPresent()) {
            logger.info("Modificando domicilio existente");
            domicilioService.registrar(domicilio);
            return ResponseEntity.ok(domicilio);
        }
        logger.info("Falló la petición o el domicilio no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Domicilio>> mostrarTodos() {
        logger.info("Consultando domicilios");
        return ResponseEntity.ok(domicilioService.mostrarTodos());
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(domicilioService.buscarPorId(id).isPresent()){
            logger.info("Borrando domicilio particular");
            domicilioService.eliminar(id);
            return "El domicilio con id " + id +  " se ha eliminado con éxito ";
        }
        logger.info("Falló la petición o el domicilio no existe");
        return "No se encontro ningun domicilio con id " + id;
    }
}