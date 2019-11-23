package com.emotel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emotel.core.entities.Usuario;



public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	 @Query("select u from Usuario u where u.correo = correo and u.password = password ")
	public Usuario buscarPorCorreo(String correo, String password);
	 @Query("select u from Usuario u where u.correo = correo")
	public Usuario existeCorreo(String correo);
}
