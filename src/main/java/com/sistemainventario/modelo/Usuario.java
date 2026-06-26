package com.sistemainventario.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPersonal;

    String nombre;
    String correo;
    String password;
    Boolean estatus = true;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;
}
