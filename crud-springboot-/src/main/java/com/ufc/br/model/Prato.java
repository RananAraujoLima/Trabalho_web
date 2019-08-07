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


@Entity
public class Prato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prato;
	private String nome;
	private double valor;
	

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	Usuario usuario;
	
	
	@OneToMany(mappedBy="prato")
    private List<Pedido> pedido;
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}



	public Long getId_prato() {
		return id_prato;
	}

	public void setId_prato(Long id_prato) {
		this.id_prato = id_prato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}



	public Long getId() {
		return id_prato;
	}

	public void setId(Long id) {
		this.id_prato = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
