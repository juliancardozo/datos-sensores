package com.example.sensorapi;

import com.example.sensorapi.model.SensorReading;
import com.example.sensorapi.repository.SensorReadingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.Month;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner loadData(SensorReadingRepository repository) {
        return args -> {
            repository.save(new SensorReading(1L, 11.10, LocalDateTime.of(2025, Month.JUNE, 16, 1, 44, 23, 321178000)));
            repository.save(new SensorReading(1L, 11.69, LocalDateTime.of(2025, Month.JUNE, 16, 2, 14, 23, 321178000)));
            repository.save(new SensorReading(1L, 12.92, LocalDateTime.of(2025, Month.JUNE, 16, 2, 44, 23, 321178000)));
            repository.save(new SensorReading(1L, 13.49, LocalDateTime.of(2025, Month.JUNE, 16, 3, 14, 23, 321178000)));
            repository.save(new SensorReading(1L, 13.79, LocalDateTime.of(2025, Month.JUNE, 16, 3, 44, 23, 321178000)));
        };
    }
}
