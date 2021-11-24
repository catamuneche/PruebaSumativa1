package com.nttdata.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //representacion de la entidad modelo
@Table(name="ventas") //nombre de la tabla en DB
public class Venta {
	@Id //este es el is o primary key de la tabla
	@GeneratedValue(strategy=GenerationType.IDENTITY) //es autoincrementable
	private Long id;
	private Usuario usuario;
	private List<Producto> listaProductos;
	
	public Venta() {
		super();
	}
	
	public Venta(Long id, Usuario usuario, List<Producto> listaProductos) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.listaProductos = listaProductos;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	@Override
	public String toString() {
		return "Venta [id=" + id + ", usuario=" + usuario + ", listaProductos=" + listaProductos + "]";
	}
	
}
