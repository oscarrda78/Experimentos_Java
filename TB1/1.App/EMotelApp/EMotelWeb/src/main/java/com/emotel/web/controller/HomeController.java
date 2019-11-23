package com.emotel.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emotel.core.entities.Usuario;
import com.emotel.core.service.NacionalidadService;
import com.emotel.core.service.UsuarioService;



@Controller
public class HomeController {

	@Autowired
	UsuarioService userserv;
	@Autowired
	NacionalidadService nacionalidadserv;
	
	@RequestMapping(value="/", method = RequestMethod.GET )
	public String index() {
		
		return "index.html";
	}
	
	@RequestMapping(value="/usuario/registrar", method = RequestMethod.GET)
	public String registrar(Model model) {
		Usuario objUsuario = new Usuario();
		model.addAttribute("usuario", objUsuario);
		model.addAttribute("nacionalidades", nacionalidadserv.listar());

		return "usuario_registrar.html";
	}
	
	@RequestMapping(value="/usuario/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute @Valid Usuario objUsuario, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) 
	{
		Usuario aux = userserv.existeCorreo(objUsuario.getCorreo());

		if(aux!=null || objUsuario.getFecha() == null) {
			objRedir.addFlashAttribute("error", "Uno o más datos no son válidos");
			return "redirect:/usuario/registrar";
		}
		else {
			boolean flag = userserv.agregar(objUsuario);
			if(flag) {
				objRedir.addFlashAttribute("mensaje", "Cuenta registrada satisfactoriamente");
				return "redirect:/usuario/registrar";
			}else {
				objRedir.addFlashAttribute("error", "Uno o más datos no son válidos");			
				return "redirect:/usuario/registrar";
			}
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		Usuario objUsuario=new Usuario();
		model.addAttribute("usuario",objUsuario);
		return "iniciar_sesion.html";
	}
	
	@RequestMapping(value="/usuario/iniciar_sesion", method = RequestMethod.POST)
	public String iniciar_sesion(@ModelAttribute @Valid Usuario objUsuario, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) {
		Usuario aux= userserv.buscarPorCorreo(objUsuario.getCorreo(), objUsuario.getPassword());
		
		if(aux == null) {
//			return "redirect:/admin/login";
			objRedir.addFlashAttribute("error", "La cuenta no está registrada");
			return "redirect:/login";
		}
		else {
//			model.addAttribute(aux);
//			objRedir.addAttribute(aux);
			return "redirect:/hotel/listar";
		}
	}
}
