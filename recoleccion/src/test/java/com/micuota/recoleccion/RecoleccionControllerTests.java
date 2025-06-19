package com.micuota.recoleccion;

import com.micuota.recoleccion.repository.RecoleccionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RecoleccionControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RecoleccionRepository repository;

    @Test
    void registrarYConsultar() throws Exception {
        String json = "{\"contenedorId\":\"C1\",\"lat\":1.1,\"lon\":2.2}";
        mockMvc.perform(post("/recoleccion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());

        mockMvc.perform(get("/recoleccion/C1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].contenedorId").value("C1"));
    }
}
