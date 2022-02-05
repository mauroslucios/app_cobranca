package com.mauroslucios.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mauroslucios.cobranca.enuns.StatusTitulo;
import com.mauroslucios.cobranca.model.Titulo;
import com.mauroslucios.cobranca.service.TituloService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Controller
@Api(value="APP de controle de cobranças")
@CrossOrigin(origins = "*")
@RequestMapping("/titulos")
@AllArgsConstructor
public class TituloController {

	private TituloService tituloService;
	private static final String CADASTRO_VIEW = "CadastroTitulo";
	
	@RequestMapping("/novo")
	@ApiOperation(value="Exibe a view de novo título")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Titulo());
		return mv;
	}
	
	@ApiOperation(value="Salva um título no banco")
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		tituloService.cadastrar(titulo);
		attributes.addFlashAttribute("mensagem","Título salvo com sucesso!");
		return "redirect:/titulos/novo";
	}
	
	@RequestMapping("/pesquisa")
	@ApiOperation(value="Busca todos os títulos no banco")
	public ModelAndView pesquisa() {
		List<Titulo> todosTitulos = tituloService.pesquisar();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
		return mv;
	}
	
	@RequestMapping("/editar/{codigo}")
	@ApiOperation(value="Edita um título")
	public ModelAndView edicao(@PathVariable Long codigo) {
		Titulo titulo = tituloService.findById(codigo);
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		return mv;
	}

	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
	
		
}
