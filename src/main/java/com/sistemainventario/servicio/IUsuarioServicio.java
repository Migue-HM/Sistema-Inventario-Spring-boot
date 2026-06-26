package com.sistemainventario.servicio;

import com.sistemainventario.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {

    public List<Usuario> listarUsuario();

    public Usuario gaurdarUsuario(Usuario usuario);

    public Usuario buscarUsuarioPorId(Integer idPersonal);

    public void bajaUsuario(Usuario idPersonal);

    public void activarUsuario(Usuario idPersonal);

}
