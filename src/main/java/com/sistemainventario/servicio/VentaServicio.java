package com.sistemainventario.servicio;

import com.sistemainventario.modelo.Ventas;

import java.util.List;

public class VentaServicio implements IVentaServicio {
    @Override
    public List<Ventas> listarVentas() {
        return List.of();
    }

    @Override
    public Ventas registrarVenta(Integer idProducto, Integer cantidad, Integer idUsuario) {
        return null;
    }
}
