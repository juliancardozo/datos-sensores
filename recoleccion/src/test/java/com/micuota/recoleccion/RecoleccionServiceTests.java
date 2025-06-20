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
        dto.temperatura = 25.0;
        dto.presion = 101.5;
        dto.capacidadOcupada = 50.0;
        dto.fecha = LocalDateTime.now();

        Recoleccion saved = service.guardar(dto);

        List<Recoleccion> list = repository.findByContenedorId("TEST1");
        assertFalse(list.isEmpty());
        Recoleccion r = list.get(0);
        assertEquals(saved.getId(), r.getId());

        assertEquals(10.0, r.getLat());
        assertEquals(20.0, r.getLon());
        assertEquals(25.0, r.getTemperatura());
        assertEquals(101.5, r.getPresion());
        assertEquals(50.0, r.getCapacidadOcupada());
    }

    @Test
    void estadisticasAgrupanDatos() {
        RecoleccionDTO dto = new RecoleccionDTO();
        dto.contenedorId = "STAT1";
        dto.lat = 0.0;
        dto.lon = 0.0;
        dto.temperatura = 0.0;
        dto.presion = 101.0;
        dto.capacidadOcupada = 0.0;
        dto.fecha = LocalDateTime.now().withHour(5);
        service.guardar(dto);

        var stats = service.obtenerEstadisticas();
        @SuppressWarnings("unchecked")
        Map<String, Long> porContenedor = (Map<String, Long>) stats.get("porContenedor");
        assertTrue(porContenedor.get("STAT1") >= 1);
    }
}
