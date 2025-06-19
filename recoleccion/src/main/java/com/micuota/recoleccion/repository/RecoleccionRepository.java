package com.micuota.recoleccion.repository;

import com.micuota.recoleccion.entity.Recoleccion;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RecoleccionRepository extends MongoRepository<Recoleccion, String> {

    List<Recoleccion> findByContenedorId(String contenedorId);
}
