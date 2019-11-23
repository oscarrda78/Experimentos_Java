package com.emotel.core.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emotel.core.entities.Distrito;



@Service
public interface IDistritoService {

	public boolean agregar(Distrito distrito);
	public List<Distrito> listar();
}
