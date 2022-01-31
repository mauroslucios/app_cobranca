package com.mauroslucios.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@Controller
@Api(value="APP de controle de cobranças")
@CrossOrigin(origins = "*")
@RequestMapping("/titulos")
@AllArgsConstructor
public class PesquisaTituloController {

}
