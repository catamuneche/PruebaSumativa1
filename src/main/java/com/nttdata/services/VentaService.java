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
	
	public void insertarventa(@Valid Venta venta) {
		ventaRepository.save(venta);
	}
	
	public void editarventa(@Valid Venta venta) {
		ventaRepository.save(venta);
	}
	
	public void eliminarventa(@Valid Venta venta) {
		ventaRepository.delete(venta);
	}

	public List<Venta> obtenerListaventa(){
		return ventaRepository.findAll();
	}
	public Venta buscarventaId(Long id) {

		return ventaRepository.findById(id).get();
	}

	public void eliminarventa(Long id) {
		ventaRepository.deleteById(id);
	}

	public void eliminarventaObjeto(Venta venta) {
		ventaRepository.delete(venta);

	}
	
}
