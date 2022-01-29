package com.mauroslucios.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/novo")
	@ApiOperation(value="Busca um titulo no banco")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("todosStatusTitulo",StatusTitulo.values());
		return mv;
	}
	
	@ApiOperation(value="Salva um título no banco")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/cadastrar")
	public ModelAndView salvar(Titulo titulo) {
		tituloService.cadastrar(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem","Título salvo com sucesso!");
		return mv;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
	
}
