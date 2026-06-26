package com.sistemainventario.servicio;

import com.sistemainventario.modelo.Historial;
import com.sistemainventario.modelo.Producto;
import com.sistemainventario.modelo.Usuario;
import com.sistemainventario.repositorio.ProductoRepositorio;
import com.sistemainventario.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private IHIstorialServicio ihIstorialServicio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    private Usuario obtenerUsuarioSesion(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String correo = authentication.getName();

        return  usuarioRepositorio.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }


    @Override
    public List<Producto> listarProducto() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto =  productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public void guardarProducto(Producto producto) {
        producto.setCantidad(0);
        producto.setActivo(true);
        productoRepositorio.save(producto);
    }

    @Override
    public void ediatrProducto(Producto producto) {
        Producto producto1 = productoRepositorio.findById(producto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto1.setNombre(producto.getNombre());
        producto1.setPrecio(producto.getPrecio());
        producto1.setActivo(producto.getActivo());
        productoRepositorio.save(producto1);
    }

    @Override
    public void bajaProducto(Integer idProducto) {
        Producto producto = productoRepositorio.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setActivo(false);
        productoRepositorio.save(producto);
    }

    @Override
    public void activarProducto(Integer idProducto) {
        Producto producto = productoRepositorio.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setActivo(true);
        productoRepositorio.save(producto);
    }

    @Override
    public void aumentarInventario(Integer idProducto, Integer cantidad) {

        if(cantidad == null || cantidad <= 0){
            throw new IllegalArgumentException("Ingrese una cantidad mayor a 0, no se pueden agregar cantidades negativas.");
        }

        Producto producto = productoRepositorio.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        producto.setCantidad(producto.getCantidad() + cantidad);
        productoRepositorio.save(producto);

        Historial historial = new Historial();

        historial.setProducto(producto);
        historial.setCantidad(cantidad);
        historial.setUsuario(obtenerUsuarioSesion());
        historial.setFecha(LocalDateTime.now());
        historial.setTipoMovimiento(Historial.TipoMovimiento.ENTRADA);

        ihIstorialServicio.guardarMovimineto(historial);
    }

    @Override
    public void disminuirInventario(Integer idProducto, Integer cantidad) throws Exception {
        Producto producto = productoRepositorio.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        if (cantidad <= 0 ){
            throw new IllegalArgumentException("Ingrese una cantidad mayor a 0.");
        }

        if (cantidad > producto.getCantidad()){
            throw new IllegalArgumentException("NO se puede quitar una cantidad mayor a la existente. Cantidad actual: " + producto.getCantidad());
        }

        producto.setCantidad(producto.getCantidad() - cantidad);
        productoRepositorio.save(producto);

        Historial historial = new Historial();

        historial.setProducto(producto);
        historial.setCantidad(cantidad);
        historial.setUsuario(obtenerUsuarioSesion());
        historial.setFecha(LocalDateTime.now());
        historial.setTipoMovimiento(Historial.TipoMovimiento.SALIDA);

        ihIstorialServicio.guardarMovimineto(historial);
    }

    @Override
    public List<Producto> buscarPorActivo() {
        return productoRepositorio.findByActivoTrue();
    }

    @Override
    public List<Producto> buscarPorInactivo() {
        return productoRepositorio.findByActivoFalse();
    }



}
