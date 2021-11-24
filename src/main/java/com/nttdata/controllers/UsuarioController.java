package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String inicio(@ModelAttribute("usuario") Usuario usuario) {
		
		return "usuario.jsp";
	}
	
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("usuario") Usuario usuario, Model model) {
String error = "";
		
		if(usuario.getNombre()==null || usuario.getNombre().isEmpty() || usuario.getApellido()==null || usuario.getApellido()==null 
				|| usuario.getApellido().isEmpty() || usuario.getRut()==null || usuario.getRut().isEmpty() || usuario.getDv()==null
				|| usuario.getDv().isEmpty()) {
			error="Los campos no pueden estar vacíos!";
			return "error.jsp";
		}
		
		if(containsDigit(usuario.getNombre())) {
			error="El nombre no puede contener números! ";
		}else if(usuario.getNombre().length()<1 || usuario.getNombre().length()>10) {
			error+="El nombre debe tener de 1 a 10 caracteres! ";
		}
		
		if(containsDigit(usuario.getApellido())) {
			error+="El apellido no puede contener números! ";
		}else if(usuario.getApellido().length()<1 || usuario.getApellido().length()>10) {
			error+="El Apellido debe tener de 1 a 10 caracteres! ";
		}
		
		if(error.isEmpty()) {
			model.addAttribute("usuario", usuario);
			
			//usuarioService.insertarUsuario(usuario,model);
			usuarioService.insertarUsuario(usuario);
			return "usuarioDatos.jsp";
		}else {
			model.addAttribute("error", error);
			return "error.jsp";
		}
		
	}
	
	//Verifica si el string es un número
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			System.out.println("error: "+nfe.getMessage());
			return false;
		}
	}
	
	//Verifica si el string contiene números
	public static boolean containsDigit(String s) {
	    boolean containsDigit = false;
	    for (char c : s.toCharArray()) {
	       if (containsDigit = Character.isDigit(c)) {
	           containsDigit=true;
	    	   break;
	       }
	    }
	    return containsDigit;
	}
}
