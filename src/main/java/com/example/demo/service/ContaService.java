package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.business.impl.CalculoTaxaDeJurosImpl;
import com.example.demo.model.Conta;
import com.example.demo.repository.ContaRepository;
import com.example.demo.service.impl.ContaServiceImpl;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContaService implements ContaServiceImpl{

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private CalculoTaxaDeJurosImpl calculoTaxaDeJuros;

	@Override
	public ResponseEntity<List<Conta>> listarTodas() {
		List<Conta> contas = contaRepository.findAll();
		return new ResponseEntity<List<Conta>>(contas , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Conta> pegarPorId(Long id) {
		Conta conta = contaRepository.getOne(id);
		if(conta == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Conta>(conta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deletarPorId(Long id) {
		try {
			contaRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Conta> atualizar(Conta conta) {
		conta.setTaxaDeJuros(calculoTaxaDeJuros.calcular());
		Conta contaResponse = contaRepository.save(conta);
		return new ResponseEntity<Conta>(contaResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Conta> salvar(Conta conta) {
		conta.setTaxaDeJuros(calculoTaxaDeJuros.calcular());
		Conta contaResponse = contaRepository.save(conta);
		return new ResponseEntity<Conta>(contaResponse, HttpStatus.CREATED);
	}

	
	
	
	
}
