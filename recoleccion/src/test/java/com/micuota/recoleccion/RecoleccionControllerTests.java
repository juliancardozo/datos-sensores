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

    }
}
