package com.nttdata.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //representacion de la entidad modelo
@Table(name="productos") //nombre de la tabla en DB
public class Producto {
	@Id //este es el is o primary key de la tabla
	@GeneratedValue(strategy=GenerationType.IDENTITY) //es autoincrementable
	private Long id;
	private String nombre;
    private String codigo;
    private int precio;
    private String descripcion;
    
	public Producto() {
		super();
	}
	
	public Producto(Long id, String nombre, String codigo, int precio, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio
				+ ", descripcion=" + descripcion + "]";
	}
    
}
