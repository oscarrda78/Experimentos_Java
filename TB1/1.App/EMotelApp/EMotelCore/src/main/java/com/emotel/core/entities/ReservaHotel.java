package com.emotel.core.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="reservahotel")
public class ReservaHotel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Hotel hotel;


	@DateTimeFormat (pattern="dd-MMM-YYYY")
	private Date fecha;
	@Min(1)
	private int nrodias;
	@Min(1)
	private int nrocuartos;
	@Min(1)
	private int nropersonas;
	@ManyToOne
	private Usuario usuario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date date) {
		this.fecha = date;
	}
	public int getNrodias() {
		return nrodias;
	}
	public void setNrodias(int nrodias) {
		this.nrodias = nrodias;
	}
	public int getNrocuartos() {
		return nrocuartos;
	}
	public void setNrocuartos(int nrocuartos) {
		this.nrocuartos = nrocuartos;
	}
	public int getNropersonas() {
		return nropersonas;
	}
	public void setNropersonas(int nropersonas) {
		this.nropersonas = nropersonas;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getPais() {
		return "Peru";
	}
}
