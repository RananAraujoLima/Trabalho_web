package com.ufc.br.security;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;


import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuarioRepository;
@Repository
@Transactional
public class UserDetailsServiceImplementacao implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByLogin(login);
		
		if (usuario == null) { 
			System.out.println("usuário não encontrado");
			throw new UsernameNotFoundException("Ususario não encontrado");
		}
		System.out.println("usuário encontrado");
		return new User(usuario.getUsername(),usuario.getPassword(),true,true,true,true,usuario.getAuthorities());
		}

}
	