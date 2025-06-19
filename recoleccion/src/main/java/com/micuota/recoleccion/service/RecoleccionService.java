package com.micuota.recoleccion.service;

import com.micuota.recoleccion.dto.RecoleccionDTO;
import com.micuota.recoleccion.entity.Recoleccion;
import com.micuota.recoleccion.repository.RecoleccionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoleccionService {
    @Autowired
    private RecoleccionRepository repository;


    private static final Logger log = LoggerFactory.getLogger(RecoleccionService.class);

    public Recoleccion guardar(RecoleccionDTO dto) {

        Recoleccion r = new Recoleccion();
        r.setContenedorId(dto.contenedorId);
        r.setLat(dto.lat);
        r.setLon(dto.lon);
        r.setRecolectado(dto.recolectado != null ? dto.recolectado : java.time.LocalDateTime.now());
        Recoleccion saved = repository.save(r);
        log.debug("Saved {}", saved);
        return saved;
    }
}
