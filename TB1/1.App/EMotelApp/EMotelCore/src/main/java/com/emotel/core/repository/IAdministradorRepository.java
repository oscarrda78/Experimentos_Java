package com.emotel.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emotel.core.entities.Administrador;




public interface IAdministradorRepository extends JpaRepository<Administrador, Integer>{

	 @Query(value="select 1 * from Administrador where a.correo = correo and a.password = password ", nativeQuery = true)
	  public List<Administrador> buscarPorCorreo(String correo,String password);
	  @Query(value="select 1 * from Administrador where a.correo = correo", nativeQuery = true)
	  public boolean existeCorreo(String correo);
	 
}
