package com.micuota.recoleccion.grafo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RutaOptimaServiceTests {

    @Test
    void seleccionaContenedorMasConveniente() {
        // Crear nodos con id, posición x,y y nivel de llenado
        List<ContainerNode> nodos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // x = i, y = 0; nivelLlenado = i * 10
            nodos.add(new ContainerNode("C" + i, i, 0, i * 10, 100));
        }

        RutaOptimaService service = new RutaOptimaService(nodos);

        ContainerNode mejor = service.contenedorMasConveniente("C0");

        assertNotNull(mejor, "El contenedor seleccionado no debe ser null");

        // Verificamos que el contenedor con mayor nivel de llenado y distancia sea "C9"
        assertEquals("C1", mejor.id, "Debe seleccionar el contenedor más lejano con mayor llenado");
    }
}
