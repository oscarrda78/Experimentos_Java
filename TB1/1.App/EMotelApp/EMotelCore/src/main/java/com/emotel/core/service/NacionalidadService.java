package com.emotel.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emotel.core.entities.Nacionalidad;
import com.emotel.core.repository.INacionalidadRepository;
@Service
public class NacionalidadService implements INacionalidadService {
	@Autowired
	INacionalidadRepository repository;
	public List<Nacionalidad> listar() {
		return repository.findAll();
	}

}
