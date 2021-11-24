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
	
	public void insertarproducto(@Valid Producto producto) {
		productoRepository.save(producto);
	}
	
	public void editarproducto(@Valid Producto producto) {
		productoRepository.save(producto);
	}
	
	public void eliminarproducto(@Valid Producto producto) {
		productoRepository.delete(producto);
	}

	public List<Producto> obtenerListaproducto(){
		return productoRepository.findAll();
	}
	public Producto buscarproductoId(Long id) {

		return productoRepository.findById(id).get();
	}

	public void eliminarproducto(Long id) {
		productoRepository.deleteById(id);
	}

	public void eliminarproductoObjeto(Producto producto) {
		productoRepository.delete(producto);

	}
	
}
