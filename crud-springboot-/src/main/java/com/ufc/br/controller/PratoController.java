package com.ufc.br.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.ufc.br.model.Pedido;
import com.ufc.br.model.Prato;

import com.ufc.br.service.UsuarioService;
import com.ufc.br.service.PratoService;

@Controller
@RequestMapping("/prato")
public class PratoController {

	@Autowired
	private PratoService pratoService;

	@RequestMapping("/formulario")
	public ModelAndView formularioCliente() {
		ModelAndView mv = new ModelAndView("prato");
		mv.addObject("prato", new Prato());
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvarCliente(Prato prato, @RequestParam(value = "imagem") MultipartFile imagem) {
		pratoService.salvarPrato(prato, imagem);
		ModelAndView mv = new ModelAndView("redirect:/prato/listar");

		return mv;

	}
	@GetMapping("/vizualizar")
	public ModelAndView vizualizarPrato() {
		List<Prato> prato = pratoService.listarPrato();
		ModelAndView mv = new ModelAndView("vizualizar-pratos");
		mv.addObject("todosOsPratos", prato);

		return mv;
	}
	@GetMapping("/listar")
	public ModelAndView listarPrato() {
		List<Prato> prato = pratoService.listarPrato();
		ModelAndView mv = new ModelAndView("pagina-listagem-pratos");
		mv.addObject("todosOsPratos", prato);

		return mv;
	}

	@RequestMapping("/atualizar/{id}")
	public ModelAndView atualizarPrato(@PathVariable Long id) {
		Prato prato = pratoService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("prato");
		mv.addObject("prato", prato);
		return mv;
	}

	@RequestMapping("/bucar/prato/{id}")
	public ModelAndView BuscarPrato(@PathVariable Long id) {
		Prato prato = pratoService.buscarPorId(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("prato", prato);
		return mv;
	}

	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirPrato(@PathVariable Long id) {
		pratoService.excluirPorId(id);
		ModelAndView mv = new ModelAndView("redirect:/prato/listar");
		return mv;
	}

}
