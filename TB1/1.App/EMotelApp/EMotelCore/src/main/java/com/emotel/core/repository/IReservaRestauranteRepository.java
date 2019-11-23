package com.emotel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emotel.core.entities.ReservaRestaurante;



@Repository
public interface IReservaRestauranteRepository extends JpaRepository<ReservaRestaurante, Integer>{

}
