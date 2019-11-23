package com.emotel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emotel.core.entities.Provincia;



@Repository
public interface IProvinciaRepository extends JpaRepository<Provincia, Integer>{

}
