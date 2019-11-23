package com.emotel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emotel.core.entities.Nacionalidad;



@Repository
public interface INacionalidadRepository extends JpaRepository<Nacionalidad, Integer>{
	
}
