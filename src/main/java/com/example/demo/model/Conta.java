package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Conta implements Serializable{
	
	private static final long serialVersionUID = -5444216656085860735L;

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
	
	@Setter(value=AccessLevel.PRIVATE)
	private Double taxaDeJuros;

	public void setJuros() {
		this.taxaDeJuros = this.risco.getJuros();
	}
}
