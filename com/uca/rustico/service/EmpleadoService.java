package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Empleado;
import com.uca.capas.dto.EditarEmpDTO;

public interface EmpleadoService {

	public List<Empleado> findAll();
	
	public void eliminarEmpleado(Integer id);
	
	public EditarEmpDTO editEmpDTO(Integer id);
	
	public void editarEmpleado(EditarEmpDTO dto);
	
	public void agregarEmpleado(EditarEmpDTO dto, Integer succId);
}
