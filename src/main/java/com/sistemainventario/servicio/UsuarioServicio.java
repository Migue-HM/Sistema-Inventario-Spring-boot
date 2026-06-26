package com.sistemainventario.servicio;

import com.sistemainventario.modelo.Usuario;
import com.sistemainventario.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio implements  IUsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario gaurdarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer idPersonal) {
        Usuario usuario = usuarioRepositorio.findById(idPersonal).orElse(null);
        return usuario;
    }

    @Override
    public void bajaUsuario(Usuario usuario) {
        usuario.setEstatus(false);
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void activarUsuario(Usuario usuario) {
        usuario.setEstatus(true);
        usuarioRepositorio.save(usuario);
    }
}
