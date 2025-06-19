package com.micuota.recoleccion.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "recolecciones")
public class Recoleccion {
    @Id
    private String id;

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

    public LocalDateTime getRecolectado() {
        return recolectado;
    }

    public void setRecolectado(LocalDateTime recolectado) {
        this.recolectado = recolectado;
    }


    @Override
    public String toString() {
        return "Recoleccion{" +
                "id=" + id +
                ", contenedorId='" + contenedorId + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", recolectado=" + recolectado +
                '}';
    }

}
