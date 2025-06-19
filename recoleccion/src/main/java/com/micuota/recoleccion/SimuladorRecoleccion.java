package com.micuota.recoleccion;

import com.micuota.recoleccion.dto.RecoleccionDTO;
import com.micuota.recoleccion.service.RecoleccionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Random;

@Configuration
public class SimuladorRecoleccion {

    private static final Logger log = LoggerFactory.getLogger(SimuladorRecoleccion.class);

    @Bean
    CommandLineRunner cargarDatos(RecoleccionService service) {
        return args -> {
            Random random = new Random();
            String[] ids = {"A1", "B2", "C3"};
            try (BufferedWriter writer = Files.newBufferedWriter(Path.of("recoleccion-datos.csv"))) {
                writer.write("id,contenedorId,lat,lon,recolectado\n");
                for (int i = 0; i < 5; i++) {
                    RecoleccionDTO dto = new RecoleccionDTO();
                    dto.contenedorId = ids[random.nextInt(ids.length)];
                    dto.lat = -34.6 + random.nextDouble() * 0.01;
                    dto.lon = -58.4 + random.nextDouble() * 0.01;
                    dto.recolectado = LocalDateTime.now().minusHours(random.nextInt(48));
                    var saved = service.guardar(dto);
                    writer.write(String.format("%s,%s,%.6f,%.6f,%s\n",
                            saved.getId(), saved.getContenedorId(), saved.getLat(), saved.getLon(), saved.getRecolectado()));
                    log.info("Insertada {}", saved);
                }
                log.info("Datos exportados a recoleccion-datos.csv");
            }
            log.info("Simulador carg\u00f3 5 eventos de recolecci\u00f3n al iniciar");
        };
    }
}
