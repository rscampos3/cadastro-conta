package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Conta;
import com.example.demo.model.Risco;
import com.example.demo.service.impl.IContaService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SalvarContaServiceTest{

	@Autowired
	private IContaService contaService;
	
	private Conta conta;
	
	@Before
	public void setConta() {
		this.conta = new Conta();
		conta.setNomeCliente("Jenifer Campos");
		conta.setLimiteCredito(new BigDecimal(20000));
		conta.setRisco(Risco.C);
	}
	
	@Test
	public void salvarConta() {
		ResponseEntity<Conta> contaResponse = this.contaService.salvar(conta);
		
		assertThat(Risco.C.getJuros() == contaResponse.getBody().getTaxaDeJuros());
	}
	
	
}
