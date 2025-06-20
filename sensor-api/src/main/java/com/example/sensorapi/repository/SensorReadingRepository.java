package com.example.sensorapi.repository;

import com.example.sensorapi.model.SensorReading;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorReadingRepository extends MongoRepository<SensorReading, Long> {
}
