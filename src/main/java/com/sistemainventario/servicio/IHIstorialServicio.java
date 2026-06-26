package com.sistemainventario.servicio;

import com.sistemainventario.modelo.Historial;

import java.util.List;

public interface IHIstorialServicio {
    public void guardarMovimineto(Historial historial);

    List<Historial> listarMovimineto();

    List<Historial> listarPorTipo(Historial.TipoMovimiento tipoMovimiento);
}
