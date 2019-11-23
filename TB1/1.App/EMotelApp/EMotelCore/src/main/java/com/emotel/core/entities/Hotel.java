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
@Table(name="hotel")
public class Hotel {

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
	private String ubicacion;
	
	
	@ManyToOne
	private TipoHotel tipohotel;
	
	@ManyToOne
	private Provincia provincia;
	
	
//	@OneToMany(mappedBy="hotel")
//	private List<Reserva> reservas;
	
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@OneToMany(mappedBy="hotel")
	private List<ReservaHotel> reservas;

	public List<ReservaHotel> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaHotel> reservas) {
		this.reservas = reservas;
	}

	public TipoHotel getTipohotel() {
		return tipohotel;
	}

	public void setTipohotel(TipoHotel tipohotel) {
		this.tipohotel = tipohotel;
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
