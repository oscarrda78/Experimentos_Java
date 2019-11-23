package com.emotel.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emotel.core.entities.Administrador;



@Service
public interface IAdministradorService {

	public boolean agregar(Administrador usuario);
	public List<Administrador> listar();
	public Administrador buscarPorCorreo(String correo,String password);
	public boolean existeCorreo(String correo);
}
