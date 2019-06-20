package com.uca.capas.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.dto.EditarEmpDTO;
import com.uca.capas.repository.EmpleadoRepository;
import com.uca.capas.repository.SucursalRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Autowired
	private EntityManager entitymanager;
	
	@Autowired
	SucursalRepository sucursalRepository;

	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	@Transactional
	public void eliminarEmpleado(Integer id) {
		// TODO Auto-generated method stub
		Empleado empleado = empleadoRepository.getOne(id);
		entitymanager.remove(empleado);
		entitymanager.flush();
	}

	@Override
	public EditarEmpDTO editEmpDTO(Integer id) {
		// TODO Auto-generated method stub
		EditarEmpDTO dto = new EditarEmpDTO();
		Empleado empleado = empleadoRepository.getOne(id);
		dto.setIdEmpleado(empleado.getIdEmpleado());
		dto.setNombreEmpleado(empleado.getNombreEmpleado());
		dto.setEdadEmpleado(empleado.getEdadEmpleado());
		dto.setGeneroEmpleado(empleado.getGeneroEmpleado());
		dto.setEstadoEmpleado(empleado.getestadoEmpleadoDelegate());
		return dto;
	}

	@Override
	@Transactional
	public void editarEmpleado(EditarEmpDTO dto) {
		// TODO Auto-generated method stub
		Empleado empleado = empleadoRepository.getOne(dto.getIdEmpleado());
		empleado.setNombreEmpleado(dto.getNombreEmpleado());
		empleado.setEdadEmpleado(dto.getEdadEmpleado());
		empleado.setGeneroEmpleado(dto.getGeneroEmpleado());
		empleado.setEstadoEmpleado(dto.getestadoEmpleadoDelegate());
		entitymanager.merge(empleado);
		entitymanager.flush();
	}

	@Override
	@Transactional
	public void agregarEmpleado(EditarEmpDTO dto, Integer succId) {
		// TODO Auto-generated method stub
		Sucursal succ = sucursalRepository.getOne(succId);
		Empleado emp = new Empleado();
		emp.setNombreEmpleado(dto.getNombreEmpleado());
		emp.setEdadEmpleado(dto.getEdadEmpleado());
		emp.setGeneroEmpleado(dto.getGeneroEmpleado());
		emp.setEstadoEmpleado(dto.getestadoEmpleadoDelegate());
		emp.setSucursal(succ);
		entitymanager.persist(emp);
		entitymanager.flush();
	}
}
