package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.br.model.Usuario;
import com.ufc.br.model.Pedido;
import com.ufc.br.repository.UsuarioRepository;
import com.ufc.br.repository.PedidoRepository;
import com.ufc.br.util.AulaFileUtils;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void salvarPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}

	public List<Pedido> listarPedido() {
		return pedidoRepository.findAll();
	}
	
	public List<Pedido> getProducts(){
		return this.pedidoRepository.findAll();
	}
	

	public Pedido buscarPorId(Long id) {
		return pedidoRepository.getOne(id);
		
	}

	public void excluirPorId(Long id) {
		pedidoRepository.deleteById(id);
		
	}

}
