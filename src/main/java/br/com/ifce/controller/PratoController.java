package br.com.ifce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.ifce.model.Prato;
import br.com.ifce.service.PratoService;


@Controller
public class PratoController {
	
	@Autowired
	private PratoService pratoService;
	
	@GetMapping("prato/formulario")
	public ModelAndView pratoFormulario () {
		ModelAndView mv = new ModelAndView ("Formulario");
		mv.addObject("prato", new Prato());
		return mv;
	}
	
	@PostMapping("prato/salvar")
	public ModelAndView cadastrarPrato (@Validated Prato prato, @RequestParam(value="imagem") MultipartFile imagem) {
		ModelAndView mv = new ModelAndView ("redirect:/prato/listar");
		pratoService.cadastrarJogo(prato, imagem);
		return mv;
	}
	
	@GetMapping("prato/listar")
	public ModelAndView listarPratos(){
		List<Prato> pratos = pratoService.listarPratos();
		ModelAndView mv = new ModelAndView("listagem-prato");
		mv.addObject("listaPratos", pratos);
		return mv;
	}
	
	@RequestMapping("prato/excluir/{codigo}")
	public ModelAndView excluirPratos (@PathVariable Long codigo) {
		pratoService.excluirPrato(codigo);
		ModelAndView mv = new ModelAndView ("redirect:/prato/listar");
		return mv;
	}
	@RequestMapping("prato/atualizar/{codigo}")
	public ModelAndView atualizarPratos (@PathVariable Long codigo) {
		Optional<Prato> prato = pratoService.buscarPorId(codigo);
		ModelAndView mv = new ModelAndView ("Formulario");
		mv.addObject("prato", prato);
		return mv;
	}

}
