package com.ufc.br.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.ufc.br.service.PedidoService;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pedido;
	private double valor;



	public boolean isList_contains() {
		return list_contains;
	}

	public void setList_contains(boolean list_contains) {
		this.list_contains = list_contains;
	}

	private boolean list_contains = false;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_prato", nullable = false)
	Prato prato;

	

	public long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(long id_pedido) {
		this.id_pedido = id_pedido;
	}



	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = prato.getValor();
	}

	public Usuario getUsuario() {
		return  usuario;
	}

	public void setUsuario(Usuario usuario) {
		
		this.usuario = usuario;
	}

	public Prato getPrato() {
		return prato;
	}

	public void setPrato(Prato prato) {
		this.prato = prato;
	}

	
	

}
