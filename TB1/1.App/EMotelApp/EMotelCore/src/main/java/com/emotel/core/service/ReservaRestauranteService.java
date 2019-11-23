package com.emotel.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emotel.core.entities.ReservaHotel;
import com.emotel.core.entities.ReservaRestaurante;
import com.emotel.core.repository.IReservaRestauranteRepository;
@Service
public class ReservaRestauranteService implements IReservaRestauranteService {
	@Autowired
	IReservaRestauranteRepository repository;
	public boolean agregar(ReservaRestaurante reservarest) {
		boolean flag = false;
		try {
			ReservaRestaurante objReservaRestaurante= repository.save(reservarest);
			if(objReservaRestaurante!= null) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public List<ReservaRestaurante> listar() {
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
	public boolean reservarRestaurante(ReservaRestaurante reservarest)
	{
		ReservaHotelService serviceReservaHotel= new ReservaHotelService();
//		ReservaHotel reservaHotel= serviceReservaHotel.getLastReservaByUser(reservarest.getUsuario());
		/*
		 * if(mismoPaisReserva(reservaHotel, reservarest)) { agregar(reservarest);
		 * return true; }
		 */
		return false;
	}
	public boolean mismoPaisReserva(ReservaHotel reservaHotel, ReservaRestaurante reservaRest)
	{
		if(reservaHotel.getPais()==reservaRest.getPais())
		{
			return true;
		}
		return false;
	}
	public ReservaRestaurante cargarReservaRestaurante(int id) {
		ReservaRestaurante objReserva = null;
		try {
			objReserva = repository.getOne(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return objReserva;
	}

}
