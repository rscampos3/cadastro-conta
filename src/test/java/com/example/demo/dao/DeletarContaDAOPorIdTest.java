package com.example.demo.dao;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.impl.IContaDAO;
import com.example.demo.model.Conta;
import com.example.demo.model.Risco;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DeletarContaDAOPorIdTest {

	@Autowired
	private IContaDAO contaDAO;

	@Before
	public void settarESalvarConta() {
		Conta conta = new Conta();
		conta.setNomeCliente("André Campos");
		conta.setLimiteCredito(new BigDecimal(25000));
		conta.setRisco(Risco.A);
		conta.setJuros();
		this.contaDAO.salvar(conta);
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void buscarEDeletarPorId() {

		this.contaDAO.deletarPorId(new Long(1));
		this.contaDAO.pegarPorId(new Long(1));
		
	}

}
