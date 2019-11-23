package com.emotel.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emotel.core.entities.Restaurante;



@Service
public interface IRestauranteService {

	public boolean agregar(Restaurante restaurante);
	public List<Restaurante> listar();
	public boolean eliminar(int id);
	public Restaurante cargarRestaurante(int id);
}
