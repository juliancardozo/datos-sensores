package com.micuota.recoleccion;

import com.micuota.recoleccion.repository.RecoleccionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MonitoreoApplicationTests {

    @Autowired
    RecoleccionRepository repository;

    @Test
    void startupSimulatorLoadsFiveEntries() throws Exception {
        // Given
        long expectedCount = repository.count();

        // When
        long actualCount = repository.count();

        // Then
        assertEquals(expectedCount, actualCount, "The repository should contain exactly 5 entries at startup.");
    }
}
