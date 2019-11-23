package com.emotel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emotel.core.entities.Restaurante;



@Repository
public interface IRestauranteRepository extends JpaRepository<Restaurante, Integer>{

}
