package com.example.sensorapi.repository.mongo;

import com.example.sensorapi.model.SensorReading;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorReadingMongoRepository extends MongoRepository<SensorReading, String> {
}
