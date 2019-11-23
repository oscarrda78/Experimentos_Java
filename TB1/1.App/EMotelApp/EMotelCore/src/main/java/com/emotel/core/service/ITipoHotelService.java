package com.emotel.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emotel.core.entities.TipoHotel;



@Service
public interface ITipoHotelService {

	public boolean agregar(TipoHotel tipohotel);
	public List<TipoHotel> listar();
	public boolean eliminar(int id);
	public TipoHotel cargarHotel(int id);
}
