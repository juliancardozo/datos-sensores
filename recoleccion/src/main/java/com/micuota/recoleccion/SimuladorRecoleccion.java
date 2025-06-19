package com.micuota.recoleccion;

import com.micuota.recoleccion.dto.RecoleccionDTO;
import com.micuota.recoleccion.service.RecoleccionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Random;

@Configuration
public class SimuladorRecoleccion {

    @Bean
    CommandLineRunner cargarDatos(RecoleccionService service) {
        return args -> {
            Random random = new Random();
            String[] ids = {"A1", "B2", "C3"};
            for (int i = 0; i < 5; i++) {
                RecoleccionDTO dto = new RecoleccionDTO();
                dto.contenedorId = ids[random.nextInt(ids.length)];
                dto.lat = -34.6 + random.nextDouble() * 0.01;
                dto.lon = -58.4 + random.nextDouble() * 0.01;
                dto.recolectado = LocalDateTime.now().minusHours(random.nextInt(48));
                service.guardar(dto);
            }
        };
    }
}
