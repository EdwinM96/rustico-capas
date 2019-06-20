package com.uca.capas.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema= "public", name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(generator = "empleado_idempleado_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "empleado_idempleado_seq", sequenceName = "public.empleado_idempleado_seq", allocationSize = 1)
	@Column(name = "IdEmpleado")
	private Integer idEmpleado;
	
	@Column(name = "nombreEmpleado")
	private String nombreEmpleado;
	
	@Column(name = "edadEmpleado")
	private BigInteger edadEmpleado;
	
	@Column(name = "generoEmpleado")
	private Character generoEmpleado;
	
	@Column(name = "estadoEmpleado")
	private Boolean estadoEmpleado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursal")
	private Sucursal sucursal;

	public Empleado() {
		//super();
	}

	public Empleado(Integer idEmpleado, String nombreEmpleado, BigInteger edadEmpleado, Character generoEmpleado,
			Boolean estadoEmpleado, Sucursal sucursal) {
		//super();
		this.idEmpleado = idEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.edadEmpleado = edadEmpleado;
		this.generoEmpleado = generoEmpleado;
		this.estadoEmpleado = estadoEmpleado;
		this.sucursal = sucursal;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public BigInteger getEdadEmpleado() {
		return edadEmpleado;
	}

	public void setEdadEmpleado(BigInteger edadEmpleado) {
		this.edadEmpleado = edadEmpleado;
	}

	public Character getGeneroEmpleado() {
		return generoEmpleado;
	}

	public void setGeneroEmpleado(Character generoEmpleado) {
		this.generoEmpleado = generoEmpleado;
	}

	public Boolean getEstadoEmpleado() {
		return estadoEmpleado;
	}

	public void setEstadoEmpleado(Boolean estadoEmpleado) {
		this.estadoEmpleado = estadoEmpleado;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	//Delegate Functions
	public String getgeneroEmpleadoDelegate() {
		String sexo = null;
		if(this.generoEmpleado == null) {
			sexo = "";
		} else if(this.generoEmpleado.equals('f') || this.generoEmpleado.equals('F')) {
			sexo = "Femenino";
		} else if(this.generoEmpleado.equals('m') || this.generoEmpleado.equals('M')) {
			sexo = "Masculino";
		}
		return sexo;
	}
	
	public String getestadoEmpleadoDelegate() {
		String estado = null;
		if(this.estadoEmpleado == null) {
			estado = "";
		} else if(this.estadoEmpleado) {
			estado = "Activo";
		} else {
			estado = "Inactivo";
		}
		return estado;
	}
}
