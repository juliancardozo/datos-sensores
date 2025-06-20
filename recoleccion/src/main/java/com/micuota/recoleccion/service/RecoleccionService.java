package com.micuota.recoleccion.service;

import com.micuota.recoleccion.dto.RecoleccionDTO;
import com.micuota.recoleccion.entity.Recoleccion;
import com.micuota.recoleccion.repository.RecoleccionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecoleccionService {
    private final RecoleccionRepository repository;

    public RecoleccionService(RecoleccionRepository repository) {
        this.repository = repository;
    }



    private static final Logger log = LoggerFactory.getLogger(RecoleccionService.class);

    public Recoleccion guardar(RecoleccionDTO dto) {


        Recoleccion r = new Recoleccion();
        r.setContenedorId(dto.contenedorId);
        r.setLat(dto.lat);
        r.setLon(dto.lon);
        r.setTemperatura(dto.temperatura);
        r.setPresion(dto.presion);
        r.setCapacidadOcupada(dto.capacidadOcupada);
        r.setFecha(dto.fecha != null ? dto.fecha : java.time.LocalDateTime.now());
        Recoleccion saved = repository.save(r);
        log.debug("Saved {}", saved);
        return saved;
    }

    public List<Recoleccion> listarTodos() {
        return repository.findAll();
    }

    public Map<String, Object> obtenerEstadisticas() {
        List<Recoleccion> all = repository.findAll();
        Map<String, Long> porContenedor = all.stream()
                .collect(Collectors.groupingBy(Recoleccion::getContenedorId, Collectors.counting()));
        Map<Integer, Long> porHora = all.stream()
                .filter(r -> r.getFecha() != null)
                .collect(Collectors.groupingBy(r -> r.getFecha().getHour(), Collectors.counting()));
        Map<String, Object> result = new HashMap<>();
        result.put("porContenedor", porContenedor);
        result.put("porHora", porHora);
        return result;
    }

}
