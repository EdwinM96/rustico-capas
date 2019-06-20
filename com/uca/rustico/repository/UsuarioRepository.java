package com.uca.capas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String>{

	//@Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?0", nativeQuery = true)
	public List<Usuario> findAll();
	
	@Query(nativeQuery = true, value = "select * "
			+ "from usuario "
			+ "where nombreUsuario = ?1 and claveUsuario = ?2")
	public Usuario findUsuarioyContraseña(String nombreUsuario, String claveUsuario);
}
