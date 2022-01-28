package com.mauroslucios.cobranca.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusTitulo {

	PENDENTE("Pendente"), RECEBIDO("Recebido");
	
	private String descricao;
	
}
