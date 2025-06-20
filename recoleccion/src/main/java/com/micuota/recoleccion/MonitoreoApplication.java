package com.micuota.recoleccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Recoleccion API", version = "v1"))
public class MonitoreoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitoreoApplication.class, args);
    }
}
