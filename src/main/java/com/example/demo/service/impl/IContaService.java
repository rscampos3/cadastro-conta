package com.example.demo.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Conta;

public interface IContaService {

	public ResponseEntity<List<Conta>> listarTodas();
	public ResponseEntity<Conta> pegarPorId(Long id);
	public ResponseEntity<?> deletarPorId(Long id);
	public ResponseEntity<Conta> atualizar(Conta conta);
	public ResponseEntity<Conta> salvar(Conta conta);
}
