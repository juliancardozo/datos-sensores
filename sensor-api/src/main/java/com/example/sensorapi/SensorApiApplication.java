package com.example.sensorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.example.sensorapi.repository.jpa.SensorReadingRepository;
import com.example.sensorapi.repository.mongo.SensorReadingMongoRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = SensorReadingRepository.class)
@EnableMongoRepositories(basePackageClasses = SensorReadingMongoRepository.class)
public class SensorApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SensorApiApplication.class, args);
    }
}
