package com.uca.capas.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class LoginDTO {

	@NotEmpty(message = "por favor ingrese su correo electronico")
	@Email(message = "su correo electronico debe ser valido")
	@Size(message = "la longitud maxima es de 100 caracteres", min = 0, max = 100)
	public String username;
	
	@NotEmpty(message = "por favor ingrese su contraseña")
	@Size(message = "la longitud maxima es de 100 caracteres", min = 0, max = 100)
	public String password;

	public LoginDTO() {
		super();
	}

	public LoginDTO(
			@NotEmpty(message = "por favor ingrese su correo electronico") @Size(message = "la longitud maxima es de 100 caracteres", min = 0, max = 100) @Email(message = "su correo electronico debe ser valido") String username,
			@NotEmpty(message = "por favor ingrese su contraseña") @Size(message = "la longitud maxima es de 100 caracteres", min = 0, max = 100) String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
