package com.emotel.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emotel.core.entities.Distrito;
import com.emotel.core.repository.IDistritoRepository;

@Service
public class DistritoService implements IDistritoService {
	@Autowired
	IDistritoRepository repository;
	
	public boolean agregar(Distrito distrito) {
		boolean flag = false;
		
		try {
			Distrito objDistrito= repository.save(distrito);
			
			if(objDistrito != null) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	public List<Distrito> listar() {
		return repository.findAll();
	}

}
