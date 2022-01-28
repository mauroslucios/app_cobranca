package com.mauroslucios.cobranca.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mauroslucios.model.Titulo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="APP de controle de cobranças")
@CrossOrigin(origins = "*")
@RequestMapping("/titulos")
public class TituloController {

	
	@GetMapping("/buscar")
	@ApiOperation(value="Busca um titulo no banco")
	public String novo() {
		return "CadastroTitulo";
	}
	
	@ApiOperation(value="Salva um título no banco")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/cadastrar")
	public String salvar(Titulo titulo) {
		return "CadastroTitulo";
	}
	
	
}
