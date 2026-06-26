package com.sistemainventario.servicio;

import com.sistemainventario.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    public List<Producto> listarProducto();

    public Producto buscarProductoPorId(Integer idProducto);

    public void guardarProducto(Producto producto);

    public void ediatrProducto(Producto producto);

    public void bajaProducto(Integer idProducto);

    public void activarProducto(Integer idProducto);

    public void aumentarInventario(Integer idProducto, Integer cantidad);

    public void disminuirInventario(Integer idProducto, Integer cantidad) throws Exception;

    public List<Producto> buscarPorActivo();

    public List<Producto> buscarPorInactivo();

}
