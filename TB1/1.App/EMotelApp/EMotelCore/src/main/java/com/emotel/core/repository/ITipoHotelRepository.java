package com.emotel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emotel.core.entities.TipoHotel;



@Repository
public interface ITipoHotelRepository extends JpaRepository<TipoHotel, Integer>{

}
