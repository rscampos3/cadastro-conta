package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.demo.dao.impl.ContaDAOImpl;
import com.example.demo.model.Conta;
import com.example.demo.repository.ContaRepository;

public class ContaDAO implements ContaDAOImpl{
	
	@Autowired
	private ContaRepository contaRepository;

	@Override
	public List<Conta> listarTodas() {
		return this.contaRepository.findAll();
	}

	@Override
	public Conta pegarPorId(Long id) {
		return this.contaRepository.getOne(id);
	}

	@Override
	public void deletarPorId(Long id) {
		this.contaRepository.deleteById(id);
	}

	@Override
	public Conta atualizar(Conta conta) {
		return this.contaRepository.save(conta);
	}

	@Override
	public Conta salvar(Conta conta) {
		return this.contaRepository.save(conta);
	}

	

}
