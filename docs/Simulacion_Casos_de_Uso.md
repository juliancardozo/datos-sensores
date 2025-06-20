# Simulación de Casos de Uso Prioritarios

Este documento describe los cambios sugeridos para replicar escenarios de monitoreo IoT siguiendo la arquitectura del repositorio.

## 1. Sensores IoT y Red de Comunicación
- Generar lecturas simuladas usando scripts o `curl` que envíen datos HTTP al servicio `sensor-api`.
- Utilizar el API `/api/readings` como punto de ingreso, sustituyendo el envío real desde dispositivos LoRaWAN/NB‑IoT.

## 2. Gateway / Concentrador
- El gateway se puede emular ejecutando un proceso que lea datos de sensores (o el simulador) y los reenvíe al backend.
- Para simplificar, se emplean llamadas REST o eventos programados en lugar de MQTT.

## 3. Backend IoT (microservicios Spring Boot)
- Los módulos `sensor-api` y `recoleccion` del repositorio representan microservicios independientes.
- Mantener la ingesta a través de los controladores REST ya presentes y almacenar los registros en las bases de datos definidas por JPA/H2.
- Por defecto, `sensor-api` usa H2 en memoria. Se puede habilitar almacenamiento en MongoDB
  estableciendo `sensor.storage.type=mongo` en las propiedades de la aplicación.

- Habilitar endpoints adicionales si se requieren consultas más específicas de contenedores o proyecciones históricas.

## 4. Frontend / Dashboard
- Puede consumirse la API desde un cliente externo o mediante herramientas como Postman para validar el flujo principal.
- La ruta `/recoleccion/export` permite obtener datos en CSV que pueden cargarse en Power BI para generar reportes.

## 5. Flujo Principal del Caso de Uso
1. **Simulación de sensores** que envían datos a `/api/readings` y `/recoleccion`.
2. **El gateway simulado** reenvía los datos de manera programada.
3. **Los microservicios** persisten la información y ofrecen los endpoints para consulta y exportación.
4. **El usuario** visualiza resultados en un dashboard o mediante herramientas de análisis.

Este enfoque aprovecha el código existente y minimiza dependencias, priorizando el flujo principal de la aplicación.

## 6. Prueba de simulación

El proyecto incluye un test llamado `SimulacionCasosDeUsoTests` que genera el
archivo `simulacion-containers.csv` con las lecturas de cinco contenedores que
se llenan a ritmos distintos. En cada paso se registran los niveles de llenado
y se marca con `FULL` cuando un contenedor alcanza el 100 %. Este CSV permite
visualizar de forma sencilla la evolución y los eventos de llenado.

## 7. Rutas óptimas con grafos

Para escenarios con **diez contenedores** se añadió una utilidad que
representa cada contenedor como un nodo de un grafo completo. La clase
`RutaOptimaService` aplica el algoritmo de **Dijkstra** para calcular la
distancia mínima entre nodos y pondera esa distancia con el nivel de llenado y
la capacidad de cada contenedor.

El método `contenedorMasConveniente(origen)` retorna el contenedor cuya relación
entre recorrido y volumen a recolectar resulta más eficiente. Este enfoque
sirve como punto de partida para modelar rutas de recolección en situaciones
reales donde la recolección periódica se ejecuta como un flujo o “tubo” de
datos que alimenta la optimización.

