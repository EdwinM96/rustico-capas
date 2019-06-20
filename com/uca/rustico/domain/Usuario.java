package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema= "public", name = "usuario")
public class Usuario {

	@Id
	@Column(name = "nombreUsuario")
	private String nombreUsuario;
	
	@Column(name = "claveUsuario")
	private String claveUsuario;

	public Usuario(String nombreUsuario, String claveUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.claveUsuario = claveUsuario;
	}

	public Usuario() {
		super();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

}
