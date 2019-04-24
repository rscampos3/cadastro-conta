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
public class ConsultarContaServicePorIDTest {

	@Autowired
	private IContaService contaService;
	
	private Long idSalvo;
	
	@Before
	public void settarESalvarConta() {
		Conta conta = new Conta();
		conta.setNomeCliente("André Campos");
		conta.setLimiteCredito(new BigDecimal(25000));
		conta.setRisco(Risco.A);
		this.idSalvo = this.contaService.salvar(conta).getBody().getId();
	}
	
	@Test
	public void buscarPorId() {
		ResponseEntity<Conta> contaResponse = this.contaService.pegarPorId(idSalvo);
		System.out.println(idSalvo + " ***************************************");
		assertThat("André Campos".equals(contaResponse.getBody().getNomeCliente()));
	}
}
