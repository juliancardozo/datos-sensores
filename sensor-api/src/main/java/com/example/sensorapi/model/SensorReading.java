package com.example.sensorapi.model;


import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Entity
@Document("sensor_readings")
public class SensorReading {
    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long containerId;

    private Double levelPercentage;

    private LocalDateTime timestamp;

    public SensorReading() {}

    public SensorReading(Long containerId, Double levelPercentage, LocalDateTime timestamp) {
        this.containerId = containerId;
        this.levelPercentage = levelPercentage;
        this.timestamp = timestamp;
    }

    public Long getId() { return id; }
    public Long getContainerId() { return containerId; }
    public void setContainerId(Long containerId) { this.containerId = containerId; }
    public Double getLevelPercentage() { return levelPercentage; }
    public void setLevelPercentage(Double levelPercentage) { this.levelPercentage = levelPercentage; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
