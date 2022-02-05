package com.mauroslucios.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping("/novo")
	@ApiOperation(value="Exibe a view de novo título")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject(new Titulo());
		return mv;
	}
	
	@ApiOperation(value="Salva um título no banco")
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		if(errors.hasErrors()) {
			return mv;
		}
		tituloService.cadastrar(titulo);
		ModelAndView mv2 = new ModelAndView("redirect:/titulos/novo");
		attributes.addFlashAttribute("mensagem","Título salvo com sucesso!");
		return mv2;
	}
	
	@RequestMapping("/pesquisa")
	@ApiOperation(value="Busca um titulo no banco")
	public ModelAndView pesquisa() {
		List<Titulo> todosTitulos = tituloService.pesquisar();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
		return mv;
	}
	
		
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
	
		
}
