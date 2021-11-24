package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Producto;

@Repository //es una interfaz que siempre extiende de CrudRepository para comunicarse con la DB
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	List<Producto> findAll();
}
