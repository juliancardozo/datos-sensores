package com.example.sensorapi.repository;

import com.example.sensorapi.model.SensorReading;
import com.example.sensorapi.repository.mongo.SensorReadingMongoRepository;

import java.util.List;

public class MongoSensorReadingStore implements SensorReadingStore {
    private final SensorReadingMongoRepository repository;

    public MongoSensorReadingStore(SensorReadingMongoRepository repository) {
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
