package com.uca.capas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer>{

	public List<Empleado> findAll();
	
	@Query(nativeQuery = true, value = "select *"
			+ "from empleado"
			+ "where idSucursal = ?1")
	public List<Empleado> findEmpleadosinSucursal(Integer dato);
	
	public Empleado getOne(Integer id);
}
