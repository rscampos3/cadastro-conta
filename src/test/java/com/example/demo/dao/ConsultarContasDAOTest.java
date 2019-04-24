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
public class ConsultarContasDAOTest {

	@Autowired
	private IContaDAO contaDAO;

	@Before
	public void setContas() {
		Conta conta1 = new Conta();
		conta1.setNomeCliente("André Campos");
		conta1.setLimiteCredito(new BigDecimal(25000));
		conta1.setRisco(Risco.A);
		conta1.setJuros();

		Conta conta2 = new Conta();
		conta2.setNomeCliente("Carlos Campos");
		conta2.setLimiteCredito(new BigDecimal(9000));
		conta2.setRisco(Risco.C);
		conta2.setJuros();

		Conta conta3 = new Conta();
		conta3.setNomeCliente("Jean Campos");
		conta3.setLimiteCredito(new BigDecimal(4000));
		conta3.setRisco(Risco.B);
		conta3.setJuros();

		this.contaDAO.salvar(conta1);
		this.contaDAO.salvar(conta2);
		this.contaDAO.salvar(conta3);

	}

	@Test
	public void listarTodas() {
		int tamanho = this.contaDAO.listarTodas().size();
		assertThat(tamanho == 3);
	}
	
}
