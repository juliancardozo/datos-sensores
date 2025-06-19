package com.micuota.recoleccion.controller;

import com.micuota.recoleccion.dto.RecoleccionDTO;
import com.micuota.recoleccion.entity.Recoleccion;
import com.micuota.recoleccion.service.RecoleccionService;
import com.micuota.recoleccion.repository.RecoleccionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recoleccion")
public class RecoleccionController {

    private static final Logger log = LoggerFactory.getLogger(RecoleccionController.class);

    @Autowired
    private RecoleccionService service;

    @Autowired
    private RecoleccionRepository repository;

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody RecoleccionDTO dto) {
        var saved = service.guardar(dto);
        log.info("Registrada {}", saved);
        return ResponseEntity.ok("Recolección registrada");
    }

    @GetMapping("/{contenedorId}")
    public List<Recoleccion> historial(@PathVariable String contenedorId) {
        List<Recoleccion> list = repository.findByContenedorId(contenedorId);
        log.info("Historial solicitado para {}: {} registros", contenedorId, list.size());
        return list;
    }
}
