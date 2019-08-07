package com.ufc.br.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Usuario;

import com.ufc.br.service.UsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	

	
	@RequestMapping("/formulario")
	public ModelAndView formularioUsuario() {
		ModelAndView mv = new ModelAndView("formulario-usuario");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarUsuario(Usuario usuario) {
		usuarioService.salvarUsuario(usuario);
		ModelAndView mv = new ModelAndView("redirect:/usuario/listar");
		
		return mv;
		
	}
	
	@GetMapping("/listar")
	public ModelAndView listarUsuario() {
	  List<Usuario> usuario = usuarioService.listarUsuarios();
	  ModelAndView mv = new ModelAndView("pagina-listagem");
	  mv.addObject("todosOsUsuarios", usuario);
	  
	  return mv;
	}
	
	@RequestMapping("/atualizar/{id}")
	public ModelAndView atualizarUsuario(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("formulario-usuario");
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirUsuario(@PathVariable Long id) {
		usuarioService.excluirPorId(id);
		ModelAndView mv = new ModelAndView("redirect:/usuario/listar");
		return mv;
	}

	@RequestMapping("/logar")
	public ModelAndView formLogin(){
		ModelAndView mv = new ModelAndView("login");
				return mv;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
