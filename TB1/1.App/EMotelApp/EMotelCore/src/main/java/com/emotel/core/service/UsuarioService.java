package com.emotel.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emotel.core.entities.Usuario;
import com.emotel.core.repository.IUsuarioRepository;
@Service
public class UsuarioService implements IUsuarioService {
	@Autowired
	IUsuarioRepository repository;
	public boolean agregar(Usuario usuario) {
		boolean flag = false;
		try {
			Usuario objUsuario= repository.save(usuario);
			if(objUsuario != null) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public List<Usuario> listar() {
		return repository.findAll();
	}

	public Usuario buscarPorCorreo(String correo, String password) {

		Usuario a = repository.buscarPorCorreo(correo, password);
		return a;
	}

	public Usuario existeCorreo(String correo) {
		
		Usuario a = repository.existeCorreo(correo);
		return a;
	}

	public Usuario cargarUsuario(int id) {
		Usuario objUsuario = null;
		try {
			objUsuario = repository.getOne(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return objUsuario;
	}

}
