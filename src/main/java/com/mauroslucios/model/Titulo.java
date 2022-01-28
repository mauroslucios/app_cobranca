package com.mauroslucios.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.mauroslucios.enuns.StatusTitulo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="tb_titulo")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Titulo {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank
	@Size(max=255)
	private String descricao;
	
	@NotBlank
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimento;
	
	@NotBlank
	private BigDecimal valor;
	
	@NotBlank
	private StatusTitulo status;
	
}
