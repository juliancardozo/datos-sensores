package com.micuota.recoleccion.controller;

import com.micuota.recoleccion.dto.RecoleccionDTO;
import com.micuota.recoleccion.entity.Recoleccion;
import com.micuota.recoleccion.service.RecoleccionService;
import com.micuota.recoleccion.repository.RecoleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recoleccion")
public class RecoleccionController {

    @Autowired
    private RecoleccionService service;

    @Autowired
    private RecoleccionRepository repository;

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody RecoleccionDTO dto) {
        service.guardar(dto);
        return ResponseEntity.ok("Recolección registrada");
    }

    @GetMapping("/{contenedorId}")
    public List<Recoleccion> historial(@PathVariable String contenedorId) {
        return repository.findByContenedorId(contenedorId);
    }
}
