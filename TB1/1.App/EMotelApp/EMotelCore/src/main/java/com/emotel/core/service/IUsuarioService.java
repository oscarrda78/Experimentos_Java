package com.emotel.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emotel.core.entities.Usuario;


@Service
public interface IUsuarioService {
	public boolean agregar(Usuario usuario);
	public List<Usuario> listar();
	public Usuario buscarPorCorreo(String correo, String password);
	public Usuario existeCorreo(String correo);
	public Usuario cargarUsuario(int id);
}
