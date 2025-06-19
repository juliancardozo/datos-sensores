package com.example.sensorapi.controller;

import com.example.sensorapi.model.SensorReading;
import com.example.sensorapi.repository.SensorReadingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/readings")
public class SensorReadingController {

    private final SensorReadingRepository repository;

    public SensorReadingController(SensorReadingRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SensorReading create(@RequestBody SensorReading reading) {
        if (reading.getTimestamp() == null) {
            reading.setTimestamp(LocalDateTime.now());
        }
        return repository.save(reading);
    }

    @GetMapping
    public List<SensorReading> findAll() {
        return repository.findAll();
    }
}
