#!/bin/bash
set -e
DIR="$(cd "$(dirname "$0")" && pwd)"

# Start garbage collection service on port 8081
"$DIR/sensor-api/mvnw" -q -f "$DIR/recoleccion/pom.xml" spring-boot:run &
PID_RECO=$!

# Start sensor API on port 8080
"$DIR/sensor-api/mvnw" -q -f "$DIR/sensor-api/pom.xml" spring-boot:run &
PID_SENSOR=$!

echo "Services running. Press Ctrl+C to stop."
trap 'kill $PID_RECO $PID_SENSOR' INT
wait $PID_RECO $PID_SENSOR
