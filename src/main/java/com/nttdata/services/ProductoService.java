package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Producto;
import com.nttdata.repositories.ProductoRepository;

@Service //se produce toda la lógica de negocio
public class ProductoService {
	@Autowired //inyección de dependencia
	ProductoRepository productoRepository;

	public void insertarProducto(@Valid Producto producto) {
		productoRepository.save(producto);
	}
	
	public void editarProducto(@Valid Producto producto) {
		productoRepository.save(producto);
	}
	
	public void eliminarProducto(@Valid Producto producto) {
		productoRepository.delete(producto);
	}

	public List<Producto> obtenerListaProducto(){
		return productoRepository.findAll();
	}

	public Producto buscarProductoId(Long id) {
		return productoRepository.findById(id).get();
	}

	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
	}

	public void eliminarProductoObjeto(Producto producto) {
		productoRepository.delete(producto);

	}
}
