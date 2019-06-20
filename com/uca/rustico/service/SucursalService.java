package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Sucursal;
import com.uca.capas.dto.EditarDTO;

public interface SucursalService {

	public List<Sucursal> findAll();
	
	public void eliminarSucursal(Integer id);
	
	public Sucursal findOne(Integer id);
	
	public EditarDTO obtenerSucursalDTO(Integer id);
	
	public void editarSucursal(EditarDTO dto);
	
	public void agregarSucursal(EditarDTO dto);
}
