package com.mauroslucios.cobranca.service;

import java.util.List;

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

	public void pesquisar(Titulo titulo) {
		tituloRepository.findAll();
	}

	
	public List<Titulo> pesquisar() {
		List<Titulo> titulos = tituloRepository.findAll();
		return titulos;
	}

	public Titulo findById(Long codigo) {
		return tituloRepository.findById(codigo).get();
	}

	public void deletar(Long codigo) {
		tituloRepository.deleteById(codigo);
	}
	
}
