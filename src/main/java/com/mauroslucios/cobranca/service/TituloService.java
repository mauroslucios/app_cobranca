package com.mauroslucios.cobranca.service;

import org.springframework.stereotype.Service;

import com.mauroslucios.cobranca.model.Titulo;
import com.mauroslucios.cobranca.repository.TituloRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TituloService {

	
	private TituloRepository tituloRepository;

	public void cadastrar(Titulo titulo) {
		tituloRepository.save(titulo);		
	}

	
}
