package com.emotel.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

//import com.emotel.core.entities.Hotel;
import com.emotel.core.entities.ReservaHotel;
//import com.emotel.core.entities.Usuario;




@Service
public interface IReservaHotelService {
	public boolean agregar(ReservaHotel reservahotel);
	public List<ReservaHotel> listar();
	public boolean eliminar(int id);
	public ReservaHotel cargarReservaHotel(int id);
	public boolean ratioPersonas(int a);
	public boolean reservarHotel(ReservaHotel reservaHotel );
	public boolean fechaCorrecta(ReservaHotel reservaHotel);
}
