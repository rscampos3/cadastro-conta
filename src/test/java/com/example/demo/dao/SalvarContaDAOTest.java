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
public class SalvarContaDAOTest{
	
	@Autowired
	private IContaDAO contaDAO;
	
	private Conta conta;
	
	@Before
	public void setConta() {
		this.conta = new Conta();
		conta.setNomeCliente("Rafael Campos");
		conta.setLimiteCredito(new BigDecimal(20000));
		conta.setRisco(Risco.B);
		conta.setJuros();
	}

	@Test
	public void salvarConta() {
		Conta contaResponse = this.contaDAO.salvar(conta);
		
		assertThat(Risco.B.getJuros()).isEqualTo(contaResponse.getTaxaDeJuros());
	}
	
}
