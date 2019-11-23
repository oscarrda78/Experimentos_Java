package com.emotel.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emotel.core.entities.ReservaHotel;
import com.emotel.core.entities.ReservaRestaurante;



@Service
public interface IReservaRestauranteService {
	public boolean agregar(ReservaRestaurante reservarest);
	public List<ReservaRestaurante> listar();
	public boolean eliminar(int id);
	public ReservaRestaurante cargarReservaRestaurante(int id);
	public boolean reservarRestaurante(ReservaRestaurante reservarest);
	public boolean mismoPaisReserva(ReservaHotel reservaHotel, ReservaRestaurante reservaRest);
}
