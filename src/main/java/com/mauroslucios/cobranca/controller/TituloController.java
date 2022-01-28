package com.mauroslucios.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Controller
@Api(value="APP de controle de cobranças")
@CrossOrigin(origins = "*")
@RequestMapping("titulos/")
public class TituloController {

	
	@GetMapping("novo")
	public String novo() {
		return "CadastroTitulo";
	}
}
