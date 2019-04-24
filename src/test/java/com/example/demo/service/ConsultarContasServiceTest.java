package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

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
public class ConsultarContasServiceTest {

	@Autowired
	private IContaService contaService;

	@Before
	public void setContas() {
		Conta conta1 = new Conta();
		conta1.setNomeCliente("André Campos");
		conta1.setLimiteCredito(new BigDecimal(25000));
		conta1.setRisco(Risco.A);

		Conta conta2 = new Conta();
		conta2.setNomeCliente("Carlos Campos");
		conta2.setLimiteCredito(new BigDecimal(9000));
		conta2.setRisco(Risco.C);

		Conta conta3 = new Conta();
		conta3.setNomeCliente("Jean Campos");
		conta3.setLimiteCredito(new BigDecimal(4000));
		conta3.setRisco(Risco.B);

		this.contaService.salvar(conta1);
		this.contaService.salvar(conta2);
		this.contaService.salvar(conta3);

	}

	@Test
	public void listarTodas() {
		int tamanho = this.contaService.listarTodas().getBody().size();
		assertThat(tamanho == 3);
	}
	
}
