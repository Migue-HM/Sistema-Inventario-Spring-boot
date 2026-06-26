package com.sistemainventario.controlador;

import com.sistemainventario.modelo.Historial;
import com.sistemainventario.servicio.HistorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HistorialControlador {

    @Autowired
    HistorialServicio historialServicio;

    @GetMapping("/historial")
    public String mostrarHistorial(@RequestParam(required = false) Historial.TipoMovimiento tipo, Model model) {

        if (tipo == null) {
            model.addAttribute("historial", historialServicio.listarMovimineto());
        } else {
            model.addAttribute("historial", historialServicio.listarPorTipo(tipo));
        }

        model.addAttribute("tipoSeleccionado", tipo);

        return "historial";
    }
}
