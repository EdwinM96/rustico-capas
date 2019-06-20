package com.uca.capas.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Sucursal;
import com.uca.capas.dto.EditarDTO;
import com.uca.capas.repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService{
	
	@Autowired
	private SucursalRepository sucursalRepository;
	
	@Autowired
	private EntityManager entitymanager;

	@Override
	public List<Sucursal> findAll() {
		// TODO Auto-generated method stub
		return sucursalRepository.findAll();
	}

	@Override
	@Transactional
	public void eliminarSucursal(Integer id) {
		// TODO Auto-generated method stub
		Sucursal sucursal =  sucursalRepository.getOne(id);    //sucursalRepository.find(id);
		entitymanager.remove(sucursal);
		entitymanager.flush();
	}

	@Override
	public Sucursal findOne(Integer id) {
		// TODO Auto-generated method stub
		return sucursalRepository.getOne(id);
	}

	@Override
	public EditarDTO obtenerSucursalDTO(Integer id) {
		// TODO Auto-generated method stub
		EditarDTO editarDTO = new EditarDTO();
		Sucursal sucursal = sucursalRepository.getOne(id);
		editarDTO.setIdSucursal(sucursal.getIdSucursal());
		editarDTO.setNombreSucursal(sucursal.getNombreSucursal());
		editarDTO.setUbicacionSucursal(sucursal.getUbicacionSucursal());
		editarDTO.setHorarioEntrada(sucursal.getHorarioEntradaDelegate());
		editarDTO.setHorarioSalida(sucursal.getHorarioSalidaDelegate());
		editarDTO.setNumeroMesas(sucursal.getNumeroMesas());
		editarDTO.setNombreGerente(sucursal.getNombreGerente());
		return editarDTO;
	}

	@Override
	@Transactional
	public void editarSucursal(EditarDTO dto) {
		// TODO Auto-generated method stub
		Sucursal succ = sucursalRepository.getOne(dto.getIdSucursal());
		succ.setNombreSucursal(dto.getNombreSucursal());
		succ.setUbicacionSucursal(dto.getUbicacionSucursal());
		succ.setHorarioEntrada(dto.getHorarioEntradaDelegate());
		succ.setHorarioSalida(dto.getHorarioSalidaDelegate());
		succ.setNumeroMesas(dto.getNumeroMesas());
		succ.setNombreGerente(dto.getNombreGerente());
		entitymanager.merge(succ);
		entitymanager.flush();
	}

	@Override
	@Transactional
	public void agregarSucursal(EditarDTO dto) {
		// TODO Auto-generated method stub
		Sucursal succ = new Sucursal();
		succ.setNombreSucursal(dto.getNombreSucursal());
		succ.setUbicacionSucursal(dto.getUbicacionSucursal());
		succ.setHorarioEntrada(dto.getHorarioEntradaDelegate());
		succ.setHorarioSalida(dto.getHorarioSalidaDelegate());
		succ.setNumeroMesas(dto.getNumeroMesas());
		succ.setNombreGerente(dto.getNombreGerente());
		entitymanager.persist(succ);
		entitymanager.flush();
	}

}
