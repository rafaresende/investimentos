package com.necromato.investimentos.usecase.gateway;

import com.necromato.investimentos.usecase.domain.CalculadoraDomain;

public interface CalculadoraGateway {
	
	public CalculadoraDomain calcularSaldoFuturo(CalculadoraDomain domain);
	public CalculadoraDomain calcularSaldoFuturoRecorrente(CalculadoraDomain domain);
	public CalculadoraDomain calcularParcelaRecorrente(CalculadoraDomain domain);
	public CalculadoraDomain calcularTempo(CalculadoraDomain domain);

}
