package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuarioRepository;

import com.ufc.br.util.AulaFileUtils;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salvarUsuario(Usuario usuario) {
		
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		
		usuarioRepository.save(usuario);
	
	
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarPorId(Long id) {
		return usuarioRepository.getOne(id);
		
	}

	public void excluirPorId(Long id) {
		usuarioRepository.deleteById(id);
		
	}
	
	

}
