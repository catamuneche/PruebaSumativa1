package com.nttdata.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Producto;
import com.nttdata.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("")
	public String index(@ModelAttribute("producto") Producto producto, Model model) {
		List<Producto> listaProducto = productoService.obtenerListaProducto();
		//Lista de producto
		model.addAttribute("listaProducto", listaProducto);
		return "producto/producto.jsp";
	}
	
	@RequestMapping("/registrarproductos")
	public String registrarProductos(@Valid @ModelAttribute("producto") Producto producto, Model model) {
		
		String error = "";
		
		if(producto.getNombreProducto() == null || producto.getNombreProducto().isEmpty() || 
				producto.getDescripcionProducto() == null || producto.getDescripcionProducto().isEmpty() ||
				producto.getPrecioProducto() == null || producto.getPrecioProducto().isEmpty() ) {
			error="Los campos no pueden estar vacíos!";
			return "/producto/error.jsp";
		}
		
		if(error.isEmpty()) {
			model.addAttribute("producto", producto);
			
			productoService.insertarProducto(producto);
			
			return "/producto/respuesta.jsp";
		}else {
			model.addAttribute("error", error);
			return "error.jsp";
		}	
	}	
	
	
	
}



