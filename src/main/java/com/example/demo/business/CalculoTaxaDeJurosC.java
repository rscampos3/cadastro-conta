package com.example.demo.business;

import com.example.demo.business.impl.CalculoTaxaDeJurosImpl;
import com.example.demo.model.Conta;

public class CalculoTaxaDeJurosC implements CalculoTaxaDeJurosImpl{
	public double calcular(Conta conta) {
		return 20.0;
	}
}
