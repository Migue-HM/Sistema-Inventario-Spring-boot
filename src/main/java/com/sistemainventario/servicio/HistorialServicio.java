package com.sistemainventario.servicio;

import com.sistemainventario.modelo.Historial;
import com.sistemainventario.repositorio.HistorialRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HistorialServicio implements IHIstorialServicio {

    @Autowired
    private HistorialRepositorio historialRepositorio;

    @Override
    public void guardarMovimineto(Historial historial) {
        historialRepositorio.save(historial);
    }

    @Override
    public List<Historial> listarMovimineto() {
        return historialRepositorio.findAllByOrderByFechaDesc();
    }

    @Override
    public List<Historial> listarPorTipo(Historial.TipoMovimiento tipoMovimiento) {
        return historialRepositorio.findByTipoMovimiento( tipoMovimiento);
    }
}
