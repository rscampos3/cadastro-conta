package com.example.demo.service;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Conta;
import com.example.demo.model.Risco;
import com.example.demo.service.impl.IContaService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DeletarContaServicePorIdTest {

	@Autowired
	private IContaService contaService;

	@Before
	public void settarESalvarConta() {
		Conta conta = new Conta();
		conta.setNomeCliente("André Campos");
		conta.setLimiteCredito(new BigDecimal(25000));
		conta.setRisco(Risco.A);
		this.contaService.salvar(conta);
	}

	@Test
	public void buscarEDeletarPorId() {
		this.contaService.deletarPorId(new Long(1));
		this.contaService.pegarPorId(new Long(1));
	}
}
