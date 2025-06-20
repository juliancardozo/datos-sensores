package com.example.sensorapi;

import com.example.sensorapi.repository.mongo.SensorReadingMongoRepository;
import com.example.sensorapi.repository.jpa.SensorReadingRepository;
import com.example.sensorapi.repository.MongoSensorReadingStore;
import com.example.sensorapi.repository.SqlSensorReadingStore;
import com.example.sensorapi.repository.SensorReadingStore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {
    @Bean
    @ConditionalOnProperty(name = "sensor.storage.type", havingValue = "sql", matchIfMissing = true)
    public SensorReadingStore sqlStore(SensorReadingRepository repository) {
        return new SqlSensorReadingStore(repository);
    }

    @Bean
    @ConditionalOnProperty(name = "sensor.storage.type", havingValue = "mongo")
    public SensorReadingStore mongoStore(SensorReadingMongoRepository repository) {
        return new MongoSensorReadingStore(repository);
    }
}
