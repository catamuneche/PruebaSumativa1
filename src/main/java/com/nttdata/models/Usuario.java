package com.nttdata.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //representacion de la entidad modelo
@Table(name="usuarios") //nombre de la tabla en DB
public class Usuario {
	@Id //este es el is o primary key de la tabla
	@GeneratedValue(strategy=GenerationType.IDENTITY) //es autoincrementable
	private Long id;
	private String nombre;
    private String apellido;
    private String rut;
    private String dv;
    
	public Usuario() {
		super();
	}
	
	public Usuario(Long id, String nombre, String apellido, String rut, String dv, String celular) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.dv = dv;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getDv() {
		return dv;
	}
	public void setDv(String dv) {
		this.dv = dv;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut + ", dv="
				+ dv + "]";
	}

    
    
}
