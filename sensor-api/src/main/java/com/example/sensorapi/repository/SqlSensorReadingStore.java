package com.example.sensorapi.repository;

import com.example.sensorapi.model.SensorReading;

import java.util.List;

public class SqlSensorReadingStore implements SensorReadingStore {
    private final SensorReadingRepository repository;

    public SqlSensorReadingStore(SensorReadingRepository repository) {
        this.repository = repository;
    }

    @Override
    public SensorReading save(SensorReading reading) {
        return repository.save(reading);
    }

    @Override
    public List<SensorReading> findAll() {
        return repository.findAll();
    }
}
