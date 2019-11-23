package com.emotel.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emotel.core.entities.TipoHotel;
import com.emotel.core.repository.ITipoHotelRepository;
@Service
public class TipoHotelService implements ITipoHotelService {
	@Autowired
	ITipoHotelRepository repository;
	public boolean agregar(TipoHotel tipohotel) {
		boolean flag = false;
		
		try {
			TipoHotel objTipoHotel= repository.save(tipohotel);
			
			if(objTipoHotel != null) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	public List<TipoHotel> listar() {
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

	public TipoHotel cargarHotel(int id) {
		TipoHotel objTipoHotel = null;
		try {
			objTipoHotel = repository.getOne(id);
			//objAutor = autorRepo.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return objTipoHotel;
	}

}
