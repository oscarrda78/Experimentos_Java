package com.emotel.core.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emotel.core.entities.ReservaHotel;
import com.emotel.core.entities.Usuario;
import com.emotel.core.repository.IReservaHotelRepository;
import com.emotel.core.repository.IUsuarioRepository;
@Service
public class ReservaHotelService implements IReservaHotelService {
	@Autowired
	IReservaHotelRepository repository;
	@Autowired
	IUsuarioRepository userRepo;
	public boolean agregar(ReservaHotel reservahotel) {
		boolean flag = false;
		try {
			
			Usuario usuario = userRepo.findById(1).get();
			reservahotel.setUsuario(usuario);
			ReservaHotel objReservaHotel= repository.save(reservahotel);
			if(objReservaHotel!= null) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
	public boolean reservarHotel(ReservaHotel reservaHotel )
	{
		
		//fechaCorrecta(reservaHotel)
		if(ratioPersonas(reservaHotel.getNrocuartos()))
		{
			return this.agregar(reservaHotel);
			
		}
		return false;
	}
//	public ReservaHotel getLastReservaByUser(Usuario user)
//	{
//		return repository.getReservaHotelByUser(user);
//	}
//	
	public List<ReservaHotel> listar() {
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

	public ReservaHotel cargarReservaHotel(int id) {
		ReservaHotel objReserva = null;
		try {
			objReserva = repository.getOne(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return objReserva;
	}
	public boolean ratioPersonas(int a) {
		// TODO Auto-generated method stub
		if(a<=3 && a>0 )
		{
			return true;
		}
		return false;
	}
	public boolean fechaCorrecta(ReservaHotel reservaHotel)
	{
		Date now=new Date();
		if(reservaHotel.getFecha().compareTo(now) > 0)
		{
			return true;
		}
		return false;
	}

}
