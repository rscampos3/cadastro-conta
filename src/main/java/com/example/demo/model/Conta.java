package com.example.demo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank(message="nome-cliente")
	private String nomeCliente;
	
	@NotNull(message="limite-credito-1")
	@DecimalMin(value="0", message="limite-credito-2")
	private BigDecimal limiteCredito;
	
	@NotNull(message="risco")
	private Risco risco;
	
	@NotNull
	private Double taxaDeJuros;

	public double calculaJuros() {
		return risco.getCalculo().calcular(this);
	}
}
