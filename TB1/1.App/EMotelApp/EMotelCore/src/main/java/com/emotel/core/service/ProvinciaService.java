package com.emotel.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emotel.core.entities.Provincia;
import com.emotel.core.repository.IProvinciaRepository;
@Service
public class ProvinciaService implements IProvinciaService {
	@Autowired
	IProvinciaRepository repository;
	public boolean agregar(Provincia provincia) {
		boolean flag = false;
		
		try {
			Provincia objProvincia= repository.save(provincia);
			
			if(objProvincia != null) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	public List<Provincia> listar() {
		return repository.findAll();
	}

}
