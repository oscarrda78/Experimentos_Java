package com.emotel.core.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Entity;

@Entity
@Table(name="restaurante")
public class Restaurante {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Size(min=3, max=50)
	private String nombre;
	@Min(10)
	private double precio;
	@NotEmpty
	@Size(min=3, max=50)
	private String descripcion;
	@NotEmpty
	@Size(min=3, max=50)
	private String ubicacion;
	
	@ManyToOne
	private Provincia provincia;

	
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@OneToMany(mappedBy="restaurante")
	private List<ReservaRestaurante> reservas;

	public void setReservas(List<ReservaRestaurante> reservas) {
		this.reservas = reservas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

	public List<ReservaRestaurante> getReservas() {
		return reservas;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
}
