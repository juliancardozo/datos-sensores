package com.micuota.recoleccion.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Recoleccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenedorId;
    private double lat;
    private double lon;
    private LocalDateTime recolectado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDateTime getRecolectado() {
        return recolectado;
    }

    public void setRecolectado(LocalDateTime recolectado) {
        this.recolectado = recolectado;
    }
}
