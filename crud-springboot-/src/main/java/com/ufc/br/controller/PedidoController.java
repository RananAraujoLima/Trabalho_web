package com.ufc.br.controller;

import java.util.List;

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


import com.ufc.br.service.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;


	@RequestMapping("/formulario")
	public ModelAndView formularioPedido() {
		ModelAndView mv = new ModelAndView("pedido");
		mv.addObject("pedido", new Pedido());
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvarPedido(Pedido pedido) {
		pedidoService.salvarPedido(pedido);
		ModelAndView mv = new ModelAndView("redirect:/pedido/listar");

		return mv;

	}

	@GetMapping("/listar")
	public ModelAndView listarPedido() {
		List<Pedido> pedido = pedidoService.listarPedido();
		ModelAndView mv = new ModelAndView("pagina-listagem-pedido");
		mv.addObject("todosOsPedidos", pedido);

		return mv;
	}
	

	


	@RequestMapping("/atualizar/{id}")
	public ModelAndView atualizarPedido(@PathVariable Long id) {
		Pedido pedido = pedidoService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("pedido");
		mv.addObject("pedido", pedido);
		return mv;
	}

	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirPedido(@PathVariable Long id) {
		pedidoService.excluirPorId(id);
		ModelAndView mv = new ModelAndView("redirect:/pedido/listar");
		return mv;
	}

}
