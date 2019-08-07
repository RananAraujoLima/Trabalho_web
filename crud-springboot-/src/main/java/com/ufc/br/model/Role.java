package com.ufc.br.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	private static final long serialVersionUID = 1L;

	@Id
	private String papel;
	
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuario;
	
	@Override
	public String getAuthority() {
		return this.papel;
	}
	

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}


	public String getRole() {
		return papel;
	}

	public void setRole(String role) {
		this.papel = role;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setClients(List<Usuario> usuario) {
		this.usuario = usuario;
	}
}
