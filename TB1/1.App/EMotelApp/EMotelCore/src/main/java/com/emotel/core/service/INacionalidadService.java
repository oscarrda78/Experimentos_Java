package com.emotel.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emotel.core.entities.Nacionalidad;




@Service
public interface INacionalidadService {
	public List<Nacionalidad> listar();
}
