package com.example.sensorapi.repository;

import com.example.sensorapi.model.SensorReading;

import java.util.List;

public interface SensorReadingStore {
    SensorReading save(SensorReading reading);
    List<SensorReading> findAll();
}
