package com.sistemainventario.repositorio;

import com.sistemainventario.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositorio extends JpaRepository<Rol, Integer> {
}
