package com.micuota.recoleccion;

import com.micuota.recoleccion.repository.RecoleccionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MonitoreoApplicationTests {

    @Autowired
    RecoleccionRepository repository;

    @Test
    void startupSimulatorLoadsFiveEntries() {
        assertEquals(5, repository.findAll().size());
}
