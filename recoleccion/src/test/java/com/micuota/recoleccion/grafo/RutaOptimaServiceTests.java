package com.micuota.recoleccion.grafo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RutaOptimaServiceTests {

    @Test
    void seleccionaContenedorMasConveniente() {
        List<ContainerNode> nodos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nodos.add(new ContainerNode("C" + i, i, 0, i * 10, 100));
        }
        RutaOptimaService service = new RutaOptimaService(nodos);
        ContainerNode mejor = service.contenedorMasConveniente("C0");
        assertNotNull(mejor);
        assertEquals("C9", mejor.id); // el más alejado pero también con mayor llenado
    }
}
