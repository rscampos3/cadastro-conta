package com.example.demo.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Conta;
import com.example.demo.model.Risco;
import com.example.demo.service.impl.IContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {
	@Autowired
	private IContaService contaService;
	
	@GetMapping
	public ResponseEntity<List<Conta>> pegarTudo(){
		return this.contaService.listarTodas();
	}
	
	@PostMapping
	public ResponseEntity<Conta> salvar(@Valid @RequestBody Conta conta){
		return this.contaService.salvar(conta);
	}
	
	@PutMapping
	public ResponseEntity<Conta> atualizar(@Valid @RequestBody Conta conta){
		return this.contaService.atualizar(conta);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		return this.contaService.deletarPorId(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> pegarPorId(@PathVariable("id") Long id){
		return this.contaService.pegarPorId(id);
	}
	
	@GetMapping("/riscos")
	public Risco[] listaDeRiscos(){
		return Risco.values();
	}
}
