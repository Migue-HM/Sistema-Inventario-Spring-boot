package com.sistemainventario.repositorio;

import com.sistemainventario.modelo.Historial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialRepositorio extends JpaRepository<Historial, Integer> {
    List<Historial> findAllByOrderByFechaDesc();

    List<Historial> findByTipoMovimiento(Historial.TipoMovimiento tipoMovimiento);
}
