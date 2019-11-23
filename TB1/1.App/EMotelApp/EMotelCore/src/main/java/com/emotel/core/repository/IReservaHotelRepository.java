package com.emotel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emotel.core.entities.ReservaHotel;
import com.emotel.core.entities.Usuario;


@Repository
public interface IReservaHotelRepository extends JpaRepository<ReservaHotel, Integer>{
	
	 @Query("select u from ReservaHotel u where u.usuario = usuario")
	public ReservaHotel getReservaHotelByUser(Usuario usuario); 
}

