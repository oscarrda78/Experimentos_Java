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

import com.emotel.core.entities.Administrador;
import com.emotel.core.service.AdministradorService;


@Controller
public class AdminController {

	@Autowired
	AdministradorService adminserv;
	
	@RequestMapping(value="/admin/dashboard", method=RequestMethod.GET)
	public String dashboard() {
		
		return "admin/dashboard.html";
	}
	@RequestMapping(value="/loginadmin", method=RequestMethod.GET)
	public String login(Model model) {
		Administrador objAdmin=new Administrador();
		model.addAttribute("administrador", objAdmin);
		return "admin/login_admin.html";
	}
	
	@RequestMapping(value="/iniciar_admin", method = RequestMethod.POST)
	public String iniciar_admin(@ModelAttribute @Valid Administrador objAdmin, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) {
		Administrador aux= adminserv.buscarPorCorreo(objAdmin.getCorreo(), objAdmin.getPassword());
		
		if(aux == null) {
			objRedir.addFlashAttribute("error", "La cuenta no está registrada");
			return "redirect:/loginadmin";
		}
		else {
			return "admin/dashboard.html";
		}
	}
}
