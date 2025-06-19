package com.example.sensorapi.controller;

import com.example.sensorapi.model.SensorReading;
import com.example.sensorapi.repository.SensorReadingStore;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/readings")
public class SensorReadingController {

    private final SensorReadingStore store;

    public SensorReadingController(SensorReadingStore store) {
        this.store = store;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SensorReading create(@RequestBody SensorReading reading) {
        if (reading.getTimestamp() == null) {
            reading.setTimestamp(LocalDateTime.now());
        }
        return store.save(reading);
    }

    @GetMapping
    public List<SensorReading> findAll() {
        return store.findAll();
    }
}
