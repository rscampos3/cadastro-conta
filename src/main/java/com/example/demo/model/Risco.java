package com.example.demo.model;

import com.example.demo.business.CalculoTaxaDeJurosA;
import com.example.demo.business.CalculoTaxaDeJurosB;
import com.example.demo.business.CalculoTaxaDeJurosC;
import com.example.demo.business.impl.CalculoTaxaDeJurosImpl;

public enum Risco {
A(new CalculoTaxaDeJurosA()),
B(new CalculoTaxaDeJurosB()),
C(new CalculoTaxaDeJurosC());

private CalculoTaxaDeJurosImpl calculo;

Risco (CalculoTaxaDeJurosImpl calculo){
	this.calculo = calculo;
}

public CalculoTaxaDeJurosImpl getCalculo() {
	return calculo;
}


}
