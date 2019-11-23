package com.emotel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emotel.core.entities.Distrito;




@Repository
public interface IDistritoRepository extends JpaRepository<Distrito, Integer>{
	
}
