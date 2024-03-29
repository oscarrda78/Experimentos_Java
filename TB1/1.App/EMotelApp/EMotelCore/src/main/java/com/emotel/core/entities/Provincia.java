package com.emotel.core.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Entity;

@Entity
@Table(name="provincia")
public class Provincia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Size(min=3, max=50)
	private String nombre;
	
	@OneToMany(mappedBy="provincia")
	private List<Distrito> distritos;
	
	@OneToMany(mappedBy="provincia")
	private List<Hotel> hoteles;
	
	@OneToMany(mappedBy="provincia")
	private List<Restaurante> restaurantes;
	
	public List<Hotel> getHoteles() {
		return hoteles;
	}
	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}
	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}
	public List<Distrito> getDistritos() {
		return distritos;
	}
	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
