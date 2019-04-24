package com.example.demo.dao.impl;

import java.util.List;

import com.example.demo.model.Conta;

public interface IContaDAO {
	List<Conta> listarTodas();
	Conta pegarPorId(Long id);
	void deletarPorId(Long id);
	Conta atualizar(Conta conta);
	Conta salvar(Conta conta);
}
