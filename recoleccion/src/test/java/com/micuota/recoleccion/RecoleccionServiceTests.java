package com.micuota.recoleccion;

import com.micuota.recoleccion.dto.RecoleccionDTO;
import com.micuota.recoleccion.entity.Recoleccion;
import com.micuota.recoleccion.repository.RecoleccionRepository;
import com.micuota.recoleccion.service.RecoleccionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecoleccionServiceTests {

    @Autowired
    RecoleccionService service;

    @Autowired
    RecoleccionRepository repository;

    @Test
    void guardarPersisteRecoleccion() {
        RecoleccionDTO dto = new RecoleccionDTO();
        dto.contenedorId = "TEST1";
        dto.lat = 10.0;
        dto.lon = 20.0;
        dto.recolectado = LocalDateTime.now();

        service.guardar(dto);

        List<Recoleccion> list = repository.findByContenedorId("TEST1");
        assertFalse(list.isEmpty());
        Recoleccion r = list.get(0);
        assertEquals(10.0, r.getLat());
        assertEquals(20.0, r.getLon());
    }
}
