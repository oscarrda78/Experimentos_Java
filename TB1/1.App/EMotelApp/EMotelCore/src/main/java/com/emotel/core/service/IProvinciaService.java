package com.emotel.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emotel.core.entities.Provincia;


@Service
public interface IProvinciaService {

	public boolean agregar(Provincia provincia);
	public List<Provincia> listar();
}
