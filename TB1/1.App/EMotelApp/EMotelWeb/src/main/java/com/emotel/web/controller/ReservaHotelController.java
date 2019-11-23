package com.emotel.web.controller;



import java.util.Date;
import java.util.GregorianCalendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emotel.core.entities.ReservaHotel;
import com.emotel.core.service.HotelService;
import com.emotel.core.service.ReservaHotelService;
import com.emotel.core.service.UsuarioService;

@Controller
public class ReservaHotelController {

	@Autowired
	ReservaHotelService reservahotelserv;
	@Autowired
	HotelService hotelserv;
	@Autowired
	UsuarioService userserv;
	
	@RequestMapping(value="/admin/reservahotel/listar", method= RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("listado", reservahotelserv.listar());
		return "admin/reservahotel_listar.html";
	}
	
	
	@RequestMapping(value="/reservahotel/listar", method= RequestMethod.GET)
	public String listar2(Model model) {
		model.addAttribute("listado", reservahotelserv.listar());
		return "reservahotel_lista.html";
	}
	@RequestMapping(value="/reservahotel/registrar", method= RequestMethod.GET)
	public String registrar(Model model) {
		ReservaHotel obj= new ReservaHotel();
		model.addAttribute("reservaHotel", obj);
		model.addAttribute("hoteles", hotelserv.listar());
		return "reservahotel_registrar.html";
	}
	@RequestMapping(value="/reservahotel/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute @Valid ReservaHotel obj, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) {
			obj.setFecha( new GregorianCalendar(12, 12, 2020).getTime());
			if(obj.getFecha() != null) {
				boolean flag = reservahotelserv.reservarHotel(obj);
				if(flag) {
					objRedir.addFlashAttribute("mensaje", "Reserva guardada");
				}else {
					objRedir.addFlashAttribute("error", "Ocurrió un error");			
				}
			} else {
				objRedir.addFlashAttribute("error", "Ingresar Fecha");	
			}
			return "redirect:/reservahotel/registrar";
	}
	@RequestMapping(value="/reservahotel/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int id, RedirectAttributes objRedir) {
		boolean flag = reservahotelserv.eliminar(id);
		
		if(flag) {
		objRedir.addFlashAttribute("mensaje", "reserva eliminada");
		}else {
			objRedir.addFlashAttribute("error", "Ocurrió un error");			
		}
		
		return "redirect:/reservahotel/listar";
	}
	
	@RequestMapping(value="/reservahotel/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		ReservaHotel obj = reservahotelserv.cargarReservaHotel(id);
		
		if(obj == null) {
			objRedir.addFlashAttribute("error", "reserva no existe");
			return "redirect:/reservahotel/listar";
		}else {
			model.addAttribute("reservaHotel", obj);
			model.addAttribute("hoteles", hotelserv.listar());
		return "reservahotel_editar.html";
		}
	}
}
