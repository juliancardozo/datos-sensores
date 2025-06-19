# Datos Sensores

This project contains two Spring Boot services used to demo sensor data and garbage collection monitoring.

Para una descripción en español del servicio interno de monitoreo de residuos industriales consulte [docs/Propuesta_Servicio_TEYMA.md](docs/Propuesta_Servicio_TEYMA.md).

## Modules

- `sensor-api` – sample REST API serving sensor readings.
- `recoleccion` – garbage collection monitoring service that preloads random events on startup.

Both modules use the Maven wrapper found in `sensor-api/mvnw`.

## Running locally

```
# Start the sensor API
./sensor-api/mvnw -q -f sensor-api/pom.xml spring-boot:run

# Start the garbage collection service
./sensor-api/mvnw -q -f recoleccion/pom.xml spring-boot:run
```

The `recoleccion` module listens on port `8081` and logs the five generated events at startup. Those events are also exported to `recoleccion-datos.csv` so they can be imported in Power BI. The service exposes `/recoleccion/export` to download the CSV and `/recoleccion/estadisticas` to retrieve aggregated counts per container and hour.


## One-click sprint review

Execute `./one-click-review.sh` to launch both services simultaneously. The script runs each module with the Maven wrapper and waits until you stop it with `Ctrl+C`.

## Running tests

Run module tests individually:

```
./sensor-api/mvnw -q -f sensor-api/pom.xml test
./sensor-api/mvnw -q -f recoleccion/pom.xml test
```

Make sure Maven dependencies are available in your environment.

