package com.emotel.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emotel.core.entities.Administrador;
import com.emotel.core.repository.IAdministradorRepository;

@Service
public class AdministradorService implements IAdministradorService {

	@Autowired
	IAdministradorRepository repository;
	
	public boolean agregar(Administrador usuario) {
		boolean flag = false;
		
		try {
			Administrador objUsuario= repository.save(usuario);
			
			if(objUsuario != null) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	public List<Administrador> listar() {
		return repository.findAll();
	}

	public Administrador buscarPorCorreo(String correo, String password) {
		Administrador a = repository.buscarPorCorreo(correo,password).get(0);
		
		return a;
	}

	public boolean existeCorreo(String correo) {
		return repository.existeCorreo(correo);
	}

}
