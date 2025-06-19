package com.micuota.recoleccion;

import com.micuota.recoleccion.repository.RecoleccionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MonitoreoApplicationTests {

    @Autowired
    RecoleccionRepository repository;

    @Test

    void startupSimulatorLoadsFiveEntries() throws Exception {
        assertEquals(5, repository.findAll().size());
        long lines = Files.lines(Path.of("recoleccion-datos.csv")).count();
        assertTrue(lines >= 6); // header + 5 entries
    }
}
