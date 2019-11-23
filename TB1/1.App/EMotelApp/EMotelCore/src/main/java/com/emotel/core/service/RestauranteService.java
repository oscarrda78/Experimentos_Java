package com.emotel.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emotel.core.entities.Restaurante;
import com.emotel.core.repository.IRestauranteRepository;
@Service
public class RestauranteService implements IRestauranteService {
	@Autowired
	IRestauranteRepository repository;
	public boolean agregar(Restaurante restaurante) {
		boolean flag = false;
		
		try {
			Restaurante objRestaurante= repository.save(restaurante);
			
			if(objRestaurante != null) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	public List<Restaurante> listar() {
		return repository.findAll();
	}

	public boolean eliminar(int id) {
		boolean flag = false;
		try {
			repository.deleteById(id);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public Restaurante cargarRestaurante(int id) {
		Restaurante objRestaurante = null;
		try {
			objRestaurante = repository.getOne(id);
			//objAutor = autorRepo.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return objRestaurante;
	}

}
