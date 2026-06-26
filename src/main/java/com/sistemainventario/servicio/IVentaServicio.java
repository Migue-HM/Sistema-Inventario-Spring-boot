package com.sistemainventario.servicio;

import com.sistemainventario.modelo.Ventas;

import java.util.List;

public interface IVentaServicio {

    public List<Ventas> listarVentas();

    public Ventas registrarVenta(Integer idProducto, Integer cantidad, Integer idUsuario);


}
