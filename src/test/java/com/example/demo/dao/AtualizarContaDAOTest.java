package com.example.demo.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.impl.IContaDAO;
import com.example.demo.model.Conta;
import com.example.demo.model.Risco;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AtualizarContaDAOTest {

	@Autowired
	private IContaDAO contaDAO;

	private Conta contaResponse;

	@Before
	public void setConta() {
		Conta conta = new Conta();
		conta.setNomeCliente("Rafael Campos");
		conta.setLimiteCredito(new BigDecimal(20000));
		conta.setRisco(Risco.B);
		conta.setJuros();

		this.contaResponse = this.contaDAO.salvar(conta);
	}

	@Test
	public void atualizarConta() {
		
		this.contaResponse.setRisco(Risco.A);
		this.contaResponse.setJuros();
		Conta conta = this.contaDAO.salvar(this.contaResponse);
		
		assertThat(Risco.A.getJuros()).isEqualTo(conta.getTaxaDeJuros());
	}
}
