package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.dao.impl.ContaDAOImpl;
import com.example.demo.model.Conta;
import com.example.demo.service.impl.ContaServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContaService implements ContaServiceImpl{

	@Autowired
	private ContaDAOImpl contaDAO;

	@Override
	public ResponseEntity<List<Conta>> listarTodas() {
		List<Conta> contas = this.contaDAO.listarTodas();
		return new ResponseEntity<List<Conta>>(contas , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Conta> pegarPorId(Long id) {
		Conta conta = this.contaDAO.pegarPorId(id);
		if(conta == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Conta>(conta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deletarPorId(Long id) {
		try {
			this.contaDAO.deletarPorId(id);
		}catch(EmptyResultDataAccessException e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Conta> atualizar(Conta conta) {
		conta.setJuros();
		Conta contaResponse = this.contaDAO.atualizar(conta);
		return new ResponseEntity<Conta>(contaResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Conta> salvar(Conta conta) {
		conta.setJuros();
		Conta contaResponse = this.contaDAO.salvar(conta);
		return new ResponseEntity<Conta>(contaResponse, HttpStatus.CREATED);
	}
	
}
