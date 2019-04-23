package com.example.demo.model;

public enum Risco {
A(new Double(0.0)),
B(new Double(10.0)),
C(new Double(20.0));

private Double juros;

Risco (Double juros){
	this.juros = juros;
}

public Double getJuros() {
	return this.juros;
}


}
