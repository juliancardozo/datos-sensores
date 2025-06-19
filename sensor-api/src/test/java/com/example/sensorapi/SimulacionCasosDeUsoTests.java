package com.example.sensorapi;

import com.example.sensorapi.model.SensorReading;
import com.example.sensorapi.repository.SensorReadingStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimulacionCasosDeUsoTests {

    @Autowired
    SensorReadingStore repository;

    @Test
    void simularLlenadoDeContenedores() throws Exception {
        Path csv = Path.of("simulacion-containers.csv");
        try (BufferedWriter writer = Files.newBufferedWriter(csv)) {
            writer.write("timestamp,containerId,level,event\n");
            int[] rates = {20, 30, 40, 50, 60};
            LocalDateTime start = LocalDateTime.of(2025, 1, 1, 0, 0);
            for (int step = 0; step < 5; step++) {
                for (int i = 0; i < rates.length; i++) {
                    double level = Math.min(100, rates[i] * (step + 1));
                    LocalDateTime ts = start.plusHours(step);
                    SensorReading r = new SensorReading((long) (i + 1), level, ts);
                    repository.save(r);
                    String event = level >= 100 && rates[i] * step < 100 ? "FULL" : "";
                    writer.write(String.format("%s,C%d,%.1f,%s%n", ts, i + 1, level, event));
                }
            }
        }
        long lines = Files.lines(csv).count();
        assertTrue(lines >= 26); // header + readings
        assertTrue(Files.readString(csv).contains("FULL"));
    }
}
