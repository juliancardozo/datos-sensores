package com.micuota.recoleccion.service;

import com.micuota.recoleccion.dto.RecoleccionDTO;
import com.micuota.recoleccion.entity.Recoleccion;
import com.micuota.recoleccion.repository.RecoleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoleccionService {
    @Autowired
    private RecoleccionRepository repository;

    public void guardar(RecoleccionDTO dto) {
        Recoleccion r = new Recoleccion();
        r.setContenedorId(dto.contenedorId);
        r.setLat(dto.lat);
        r.setLon(dto.lon);
        r.setRecolectado(dto.recolectado != null ? dto.recolectado : java.time.LocalDateTime.now());
        repository.save(r);
    }
}
