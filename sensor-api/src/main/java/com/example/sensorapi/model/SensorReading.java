package com.example.sensorapi.model;


import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.UUID;

@Document("sensor_readings")
public class SensorReading {
    @org.springframework.data.annotation.Id
    private String id = UUID.randomUUID().toString();

    private Long containerId;

    private Double levelPercentage;

    private LocalDateTime timestamp;

    public SensorReading() {}

    public SensorReading(Long containerId, Double levelPercentage, LocalDateTime timestamp) {
        this.containerId = containerId;
        this.levelPercentage = levelPercentage;
        this.timestamp = timestamp;
    }

    public String getId() { return id; }
    public Long getContainerId() { return containerId; }
    public void setContainerId(Long containerId) { this.containerId = containerId; }
    public Double getLevelPercentage() { return levelPercentage; }
    public void setLevelPercentage(Double levelPercentage) { this.levelPercentage = levelPercentage; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
