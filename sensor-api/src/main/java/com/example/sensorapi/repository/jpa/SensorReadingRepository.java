package com.example.sensorapi.repository.jpa;

import com.example.sensorapi.model.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorReadingRepository extends JpaRepository<SensorReading, String> {
}
