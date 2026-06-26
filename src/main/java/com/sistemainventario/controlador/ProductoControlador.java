package com.sistemainventario.controlador;

import com.sistemainventario.modelo.Producto;
import com.sistemainventario.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductoControlador {

    private static final Logger loger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    ProductoServicio productoServicio;

    @GetMapping("/")
    public String iniciar(ModelMap modelo){
        List<Producto> productos = productoServicio.listarProducto();
        productos.forEach((producto) -> loger.info(producto.toString()));
        modelo.put("productos", productos);
        return  "index"; //Thymeleaf coloca la extension por default de HTML (index.html)
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "agregarProducto";
    }

    @PostMapping("/agregar")
    public String agregarProducto(@ModelAttribute("productoForma") Producto producto ){
        loger.info("Contacto a agregar: " + producto);
        productoServicio.guardarProducto(producto);
        return "redirect:/";  //Redireccion al controlador path inicio "/"
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable Integer id, ModelMap modelo){
        Producto producto = productoServicio.buscarProductoPorId(id);
        modelo.put("productoForma", producto);
        return "editarPorducto";
    }

    @PostMapping("/editar/{id}")
    public String editarProducto(@PathVariable Integer id, @ModelAttribute("productoForma") Producto producto){
        producto.setIdProducto(id);
        productoServicio.ediatrProducto(producto);
        return "redirect:/";
    }

    @PostMapping("/aumentar")
    public String aumenatrInventario(@RequestParam Integer idProducto, @RequestParam Integer cantidad,
                                     RedirectAttributes redirectAttributes){

        try{

            productoServicio.aumentarInventario(idProducto, cantidad);
            redirectAttributes.addFlashAttribute("mensajeExito","Invenatrio actuailizado correctamente.");

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("mensajeError", e.getMessage());
        }

        return "redirect:/";
    }

    @PostMapping("/quitar")
    public String quitarInventario(@RequestParam Integer idProducto, @RequestParam Integer cantidad,
                                   RedirectAttributes redirectAttributes) throws Exception {

        try{
            productoServicio.disminuirInventario(idProducto, cantidad);
            redirectAttributes.addFlashAttribute("mensajeExito", "Inventario actualizado correctamente.");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("mensajeError", e.getMessage());
        }

        return "redirect:/";
    }

    @PostMapping("/baja/{id}")
    public String darBaja(@PathVariable Integer id){
        productoServicio.bajaProducto(id);
        return "redirect:/";
    }

    @PostMapping("/activar/{id}")
    public String actiavr(@PathVariable Integer id){
        productoServicio.activarProducto(id);
        return "redirect:/";
    }

    @GetMapping("/salida")
    public String mostrarActivos(Model modelo){
        modelo.addAttribute("productos", productoServicio.buscarPorActivo());
        return "salidaProducto";
    }

}
