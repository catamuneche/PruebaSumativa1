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

import com.nttdata.models.Producto;
import com.nttdata.models.Venta;
import com.nttdata.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	@Autowired
	VentaService ventaService;
	
	@RequestMapping("")
	public String index(@ModelAttribute("venta") Producto producto, Model model) {
		List<Venta> listaVenta = ventaService.obtenerListaVenta();
		//Lista de venta
		model.addAttribute("listaVenta", listaVenta);
		return "venta/venta.jsp";
	}
	
	@RequestMapping("/registrarventa")
	public String registrarProductos(@Valid @ModelAttribute("venta") Venta venta, Model model) {
		
		String error = "";
		
		if(venta.getDetalle() == null || venta.getDetalle().isEmpty()) {
			error="El campo no pueden estar vacíos!";
			return "/venta/error.jsp";
		}
		
		if(error.isEmpty()) {
			model.addAttribute("venta", venta);
			
			ventaService.insertarVenta(venta);
			
			return "/venta/respuesta.jsp";
		}else {
			model.addAttribute("error", error);
			return "error.jsp";
		}	
	}	
	
	//Eliminar usuario
		@RequestMapping("/eliminar/venta/{id}")
		public String eliminar(@PathVariable("id") Long id) {

			Venta venta = ventaService.buscarVentaId(id);
			if(venta != null) {
				ventaService.eliminarVenta(id);
				return "Venta Eliminado";

			}else {
				return "Venta No Pudo Ser Eliminado";

			}
		}
		
		@RequestMapping("/eliminar")
		public String eliminarVenta(@RequestParam("id") Long id) {

			Venta venta = ventaService.buscarVentaId(id);

			if(venta !=null) {
				ventaService.eliminarVentaObjeto(venta);
			}

			return "redirect:/venta";
		}
		
		@RequestMapping("/editar")
		public String editar(@RequestParam("id") Long id, Model model, HttpSession session) {

			Venta venta = ventaService.buscarVentaId(id);
			System.out.println(venta.toString());

			session.setAttribute("ventaAntiguo", venta);

			model.addAttribute("editarVenta", venta);
			return "editarUsuario.jsp";
		}

		@RequestMapping("/editarVenta")
		public String editarVenta(@ModelAttribute("editarVenta") Venta venta, Model model, HttpSession session) {

			Venta ventaAntiguo = (Venta)session.getAttribute("usuarioAntiguo");

			System.out.println("Detalle nuevo: "+ venta.getDetalle());
			String error = validaVenta(venta, model);
			if(error.isEmpty()) {
				ventaAntiguo.setDetalle(venta.getDetalle());
		
				ventaService.editarVenta(ventaAntiguo);
				//model.addAttribute("usuario", new Usuario());
				return "redirect:/usuario";
			}else {
				return "error.jsp";
			}
		}
		
		
		private String validaVenta(@Valid @ModelAttribute("usuario") Venta venta, Model model) {
			Boolean flagDetalle = false;
			String error="";

			//Validación detalle
			if (venta.getDetalle().length() > 1) {
				System.out.println("ta bien el detalle");
				flagDetalle=true;
			}else {
				error+="El nombre debe tener de 1 a 10 caracteres! ";
				System.out.println("======RECUERDA=======");
				System.out.println("El nombre no puede ser mayor a 10 caracteres");
				
			}
			
				
			if(flagDetalle && error.isEmpty()) {
				//si esta bien
				model.addAttribute("detalle", venta.getDetalle());

				ventaService.insertarVenta(venta);
				
				return error;
			}else {
				model.addAttribute("error", error);
				//Si esta mal
				return error;
				
			}
		}
	
}
