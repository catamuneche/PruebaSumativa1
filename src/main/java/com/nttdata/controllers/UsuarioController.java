package com.nttdata.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String index(@ModelAttribute("usuario") Usuario usuario, Model model) {
		List<Usuario> listaUsuarios = usuarioService.obtenerListaUsuario();
		//Lista de usuario
		model.addAttribute("listaUsuarios", listaUsuarios);
		return "usuario/usuario.jsp";
	}
	
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("usuario") Usuario usuario, Model model) {
		String error = "";
		
		if(usuario.getNombre()==null || usuario.getNombre().isEmpty() 
				|| usuario.getApellido()==null || usuario.getApellido().isEmpty() ) {
			error="Los campos no pueden estar vacíos!";
			return "error.jsp";
		}
		
		if(error.isEmpty()) {
			model.addAttribute("usuario", usuario);
			
			usuarioService.insertarUsuario(usuario);
			
			return "usuario/respuesta.jsp";
		}else {
			model.addAttribute("error", error);
			return "error.jsp";
		}	
	}	
	
	//Eliminar usuario
	@RequestMapping("/eliminar/usuario/{id}")
	public String eliminar(@PathVariable("id") Long id) {

		Usuario usuario = usuarioService.buscarUsuarioId(id);
		if(usuario != null) {
			usuarioService.eliminarUsuario(id);
			return "Usuario Eliminado";

		}else {
			return "Usuario No Pudo Ser Eliminado";

		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminarUsuario(@RequestParam("id") Long id) {

		Usuario usuario = usuarioService.buscarUsuarioId(id);

		if(usuario !=null) {
			usuarioService.eliminarUsuarioObjeto(usuario);
		}

		return "redirect:/usuario";
	}
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("id") Long id, Model model, HttpSession session) {

		Usuario usuario = usuarioService.buscarUsuarioId(id);
		System.out.println(usuario.toString());

		session.setAttribute("usuarioAntiguo", usuario);

		model.addAttribute("editarUsuario", usuario);
		return "editarUsuario.jsp";
	}

	@RequestMapping("/editarUsuario")
	public String editarUsuario(@ModelAttribute("editarUsuario") Usuario usuario, Model model, HttpSession session) {

		Usuario usuarioAntiguo = (Usuario)session.getAttribute("usuarioAntiguo");

		System.out.println("Nombre nuevo: "+ usuario.getNombre());
		String error = validaUsuario(usuario, model);
		if(error.isEmpty()) {
			usuarioAntiguo.setNombre(usuario.getNombre());
			usuarioAntiguo.setApellido(usuario.getApellido());
	
			usuarioService.editarUsuario(usuarioAntiguo);
			//model.addAttribute("usuario", new Usuario());
			return "redirect:/usuario";
		}else {
			return "error.jsp";
		}
	}
	
	
	private String validaUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, Model model) {
		Boolean flagNombre = false;
		Boolean flagApellido = false;
		String error="";

		//Validación nombre
		if (usuario.getNombre().length() > 1 && usuario.getNombre().length() < 10) {
			System.out.println("ta bien el nombre");
			flagNombre=true;
		}else {
			error+="El nombre debe tener de 1 a 10 caracteres! ";
			System.out.println("======RECUERDA=======");
			System.out.println("El nombre no puede ser mayor a 10 caracteres");
			
		}
		
		//Validación apellido
		if (usuario.getApellido().length() > 1 ) {
			System.out.println("ta bien el apellido");
			flagApellido=true;
		}else {
			error+="El apellido debe tener de 1 a 10 caracteres! ";
			System.out.println("======RECUERDA=======");
			System.out.println("El apellido no puede ser mayor a 10 caracteres");
		}
		
			
		if(flagNombre && flagApellido && error.isEmpty()) {
			//si esta bien
			model.addAttribute("nombre", usuario.getNombre());
			model.addAttribute("apellido", usuario.getApellido());

			usuarioService.insertarUsuario(usuario);
			
			return error;
		}else {
			model.addAttribute("error", error);
			//Si esta mal
			return error;
			
		}
	}
}
