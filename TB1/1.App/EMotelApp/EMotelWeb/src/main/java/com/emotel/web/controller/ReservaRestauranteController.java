package com.emotel.web.controller;



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

import com.emotel.core.entities.ReservaRestaurante;
import com.emotel.core.service.ReservaRestauranteService;
import com.emotel.core.service.RestauranteService;
import com.emotel.core.service.UsuarioService;


@Controller
public class ReservaRestauranteController {

	@Autowired
	ReservaRestauranteService reservarestserv;
	@Autowired
	RestauranteService restauranteserv;
	@Autowired
	UsuarioService userserv;
	
	@RequestMapping(value="/admin/reservarest/listar", method= RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("listado", reservarestserv.listar());
		return "admin/reservarest_listar.html";
	}
		
	@RequestMapping(value="/reservarest/listar", method= RequestMethod.GET)
	public String listar2(Model model) {
		model.addAttribute("listado", reservarestserv.listar());
		return "reservarest_lista.html";
	}
	@RequestMapping(value="/reservarest/registrar", method= RequestMethod.GET)
	public String registrar(Model model) {
		ReservaRestaurante obj= new ReservaRestaurante();
		model.addAttribute("reservaRestaurante", obj);
		model.addAttribute("restaurantes", restauranteserv.listar());
		return "reservarestaurante_registrar.html";
	}
	@RequestMapping(value="/reservarest/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute @Valid ReservaRestaurante obj, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) {
		
		if(obj.getFecha() != null) {
			boolean flag = reservarestserv.agregar(obj);
			if(flag) {
				objRedir.addFlashAttribute("mensaje", "Reserva guardada");
			}else {
				objRedir.addFlashAttribute("mensaje", "Ocurrió un error");			
			}
		} else {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");	
		}
		return "redirect:/reservahotel/registrar";
	}
	@RequestMapping(value="/reservarest/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int id, RedirectAttributes objRedir) {
		boolean flag = reservarestserv.eliminar(id);
		
		if(flag) {
			objRedir.addFlashAttribute("mensaje", "reserva eliminada");
		}else {
			objRedir.addFlashAttribute("error", "Ocurrió un error");			
		}
		
		return "redirect:/reservarest/listar";
	}
	
	@RequestMapping(value="/reservarest/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		ReservaRestaurante obj = reservarestserv.cargarReservaRestaurante(id);
		
		if(obj == null) {
			objRedir.addFlashAttribute("error", "reserva no existe");
			return "redirect:/reservarest/listar";
		}else {
			model.addAttribute("reservaRestaurante", obj);
			model.addAttribute("restaurantes", restauranteserv.listar());
			return "reservarest_editar.html";
		}	
	}
}
