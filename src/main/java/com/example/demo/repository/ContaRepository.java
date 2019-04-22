package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
