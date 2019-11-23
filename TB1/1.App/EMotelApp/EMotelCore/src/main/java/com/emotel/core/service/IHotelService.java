package com.emotel.core.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emotel.core.entities.Hotel;



@Service
public interface IHotelService {
	
	public boolean agregar(Hotel hotel);
	public List<Hotel> listar();
	public boolean eliminar(int id);
	public Hotel cargarHotel(int id);
}
