package com.sistemainventario.repositorio;

import com.sistemainventario.modelo.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepositorio extends JpaRepository<Ventas, Integer> {
}
