package com.micuota.recoleccion.grafo;

import lombok.AllArgsConstructor;

/**
 * Representa un contenedor con su ubicación y estado de llenado.
 */
public class ContainerNode {
    public final String id;
    public final double lat;
    public final double lon;
    public final double fillLevel; // 0 a 100
    public final double capacity; // volumen total

    public ContainerNode(String id, double lat, double lon, double fillLevel, double capacity) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.fillLevel = fillLevel;
        this.capacity = capacity;
    }

    /**
     * Cantidad absoluta de residuos actualmente en el contenedor.
     */
    public double collectedVolume() {
        return fillLevel / 100.0 * capacity;
    }
}
