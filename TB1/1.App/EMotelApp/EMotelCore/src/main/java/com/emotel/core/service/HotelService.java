package com.emotel.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emotel.core.entities.Hotel;
import com.emotel.core.repository.IHotelRepository;
@Service
public class HotelService implements IHotelService {
	@Autowired
	IHotelRepository repository;
	public boolean agregar(Hotel hotel) {
		boolean flag = false;
		
		try {
			Hotel objHotel= repository.save(hotel);
			
			if(objHotel != null) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	public List<Hotel> listar() {
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

	public Hotel cargarHotel(int id) {
		Hotel objHotel = null;
		try {
			objHotel = repository.getOne(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return objHotel;
	}

}
