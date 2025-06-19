package com.micuota.recoleccion.repository;

import com.micuota.recoleccion.entity.Recoleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecoleccionRepository extends JpaRepository<Recoleccion, Long> {
    List<Recoleccion> findByContenedorId(String contenedorId);
}
