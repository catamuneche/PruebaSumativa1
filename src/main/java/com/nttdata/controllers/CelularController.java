package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Celular;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/celular")
public class CelularController {

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("celular", new Celular());
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		
		return "celular/celular.jsp";
	}

}
