package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Conta;

@Repository
public interface ContaDAOImpl {
	public List<Conta> listarTodas();
	public Conta pegarPorId(Long id);
	public void deletarPorId(Long id);
	public Conta atualizar(Conta conta);
	public Conta salvar(Conta conta);
}
