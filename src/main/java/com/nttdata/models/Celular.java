package com.nttdata.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity  //representacion de la entidad modelo
@Table(name="celulares") //nombre de la tabla en DB
public class Celular {
	@Id //este es el is o primary key de la tabla
	@GeneratedValue(strategy=GenerationType.IDENTITY) //es autoincrementable
	private Long id;
	private String numero;
	
	//relacion 1 a 1
  	@OneToOne(fetch = FetchType.LAZY) //lazy significa que trae toda la data de sus tablas con relacion
  	@JoinColumn(name="usuario_id")
  	private Usuario usuario;
  	
	public Celular(Long id, String numero) {
		super();
		this.id = id;
		this.numero = numero;
	}
	public Celular() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
  	
  	
}
