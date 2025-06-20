package com.micuota.recoleccion.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "recolecciones")
public class Recoleccion {

    @Id
    private String id;

    private String contenedorId;
    private double lat;
    private double lon;
    private double temperatura;
    private double presion;
    private double capacidadOcupada;
    private LocalDateTime fecha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContenedorId() {
        return contenedorId;
    }

    public void setContenedorId(String contenedorId) {
        this.contenedorId = contenedorId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getPresion() {
        return presion;
    }

    public void setPresion(double presion) {
        this.presion = presion;
    }

    public double getCapacidadOcupada() {
        return capacidadOcupada;
    }

    public void setCapacidadOcupada(double capacidadOcupada) {
        this.capacidadOcupada = capacidadOcupada;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Recoleccion{" +
                "id='" + id + '\'' +
                ", contenedorId='" + contenedorId + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", temperatura=" + temperatura +
                ", presion=" + presion +
                ", capacidadOcupada=" + capacidadOcupada +
                ", fecha=" + fecha +
                '}';
    }
}
