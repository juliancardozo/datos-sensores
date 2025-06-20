package com.micuota.recoleccion.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecoleccionDTO {
    public String contenedorId;
    public double lat;
    public double lon;
    public double temperatura;
    public double presion;
    @JsonProperty("capacidad_ocupada")
    public double capacidadOcupada;
    public LocalDateTime fecha;
}
