package com.uca.capas.domain;

import java.math.BigInteger;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(schema= "public", name = "sucursal")
public class Sucursal {

	@Id
	@GeneratedValue(generator = "sucursal_idsucursal_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sucursal_idsucursal_seq", sequenceName = "public.sucursal_idsucursal_seq", allocationSize = 1)
	@Column(name = "IdSucursal")
	private Integer idSucursal;
	
	@Column(name = "nombreSucursal")
	private String nombreSucursal;
	
	@Column(name = "ubicacionSucursal")
	private String ubicacionSucursal;
	
	@Column(name = "horarioEntrada")
	private Time horarioEntrada;
	
	@Column(name = "horarioSalida")
	private Time horarioSalida;
	
	@Column(name = "numeroMesas")
	private BigInteger numeroMesas;
	
	@Column(name = "nombreGerente")
	private String nombreGerente;

	@OneToMany(mappedBy = "sucursal", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Empleado> empleados;

	public Sucursal() {
		//super();
	}

	public Sucursal(Integer idSucursal, String nombreSucursal, String ubicacionSucursal, Time horarioEntrada,
			Time horarioSalida, BigInteger numeroMesas, String nombreGerente, List<Empleado> empleados) {
		//super();
		this.idSucursal = idSucursal;
		this.nombreSucursal = nombreSucursal;
		this.ubicacionSucursal = ubicacionSucursal;
		this.horarioEntrada = horarioEntrada;
		this.horarioSalida = horarioSalida;
		this.numeroMesas = numeroMesas;
		this.nombreGerente = nombreGerente;
		this.empleados = empleados;
	}

	public Integer getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public String getUbicacionSucursal() {
		return ubicacionSucursal;
	}

	public void setUbicacionSucursal(String ubicacionSucursal) {
		this.ubicacionSucursal = ubicacionSucursal;
	}

	public Time getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(Time horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public Time getHorarioSalida() {
		return horarioSalida;
	}

	public void setHorarioSalida(Time horarioSalida) {
		this.horarioSalida = horarioSalida;
	}

	public BigInteger getNumeroMesas() {
		return numeroMesas;
	}

	public void setNumeroMesas(BigInteger numeroMesas) {
		this.numeroMesas = numeroMesas;
	}

	public String getNombreGerente() {
		return nombreGerente;
	}

	public void setNombreGerente(String nombreGerente) {
		this.nombreGerente = nombreGerente;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	//Delegate Functions
	public String getHorarioEntradaDelegate() {
		if(this.horarioEntrada == null) return "";
		else {
			String horaEntrada = horarioEntrada.toString().substring(0, 5);
			return horaEntrada;
		}
	}
	
	public String getHorarioSalidaDelegate() {
		if(this.horarioSalida == null) return "";
		else {
			String horarSalida = horarioSalida.toString().substring(0, 5);
			return horarSalida;
		}
	}
}
