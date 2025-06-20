package com.micuota.recoleccion;

import com.example.sensorapi.SensorApiApplication;
import com.example.sensorapi.model.SensorReading;
import com.micuota.recoleccion.dto.RecoleccionDTO;
import com.micuota.recoleccion.entity.Recoleccion;
import com.micuota.recoleccion.MonitoreoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = {SensorApiApplication.class, MonitoreoApplication.class},
    properties = {"sensor.storage.type=mongo", "server.port=0"})
public class CrossServicesIntegrationTest {

    @Container
    static MongoDBContainer mongo = new MongoDBContainer("mongo:7");

    @DynamicPropertySource
    static void mongoProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongo::getReplicaSetUrl);
    }

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int port;

    @Test
    void readingFlowsBetweenServices() {
        SensorReading reading = new SensorReading();
        reading.setContainerId(99L);
        reading.setLevelPercentage(55.5);
        SensorReading created = restTemplate.postForObject("http://localhost:" + port + "/api/readings",
                reading, SensorReading.class);
        assertNotNull(created.getId());

        RecoleccionDTO dto = new RecoleccionDTO();
        dto.contenedorId = String.valueOf(created.getContainerId());
        dto.lat = 0.0;
        dto.lon = 0.0;
        restTemplate.postForObject("http://localhost:" + port + "/recoleccion", dto, Recoleccion.class);

        Recoleccion[] list = restTemplate.getForObject("http://localhost:" + port + "/recoleccion/" + dto.contenedorId,
                Recoleccion[].class);
        assertTrue(list.length > 0);
    }
}
