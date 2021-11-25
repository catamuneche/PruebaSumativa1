package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Venta;
import com.nttdata.repositories.VentaRepository;

@Service //se produce toda la lógica de negocio
public class VentaService {
	@Autowired //inyección de dependencia
	VentaRepository ventaRepository;

	public void insertarVenta(@Valid Venta venta) {
		ventaRepository.save(venta);
	}
	
	public void editarVenta(@Valid Venta venta) {
		ventaRepository.save(venta);
	}
	
	public void eliminarVenta(@Valid Venta venta) {
		ventaRepository.delete(venta);
	}

	public List<Venta> obtenerListaVenta(){
		return ventaRepository.findAll();
	}

	public Venta buscarVentaId(Long id) {
		return ventaRepository.findById(id).get();
	}

	public void eliminarVenta(Long id) {
		ventaRepository.deleteById(id);
	}

	public void eliminarVentaObjeto(Venta venta) {
		ventaRepository.delete(venta);

	}
}
