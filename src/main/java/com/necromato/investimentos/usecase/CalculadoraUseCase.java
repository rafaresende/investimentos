package com.necromato.investimentos.usecase;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.necromato.investimentos.usecase.domain.CalculadoraDomain;
import com.necromato.investimentos.usecase.gateway.CalculadoraGateway;

@Component
public class CalculadoraUseCase {

	@Autowired
	private CalculadoraGateway gateway;

	public CalculadoraDomain calcularSaldoFuturo(CalculadoraDomain domain) {

		if (domain.getValorRecorrente() != null)
			return gateway.calcularSaldoFuturoRecorrente(domain);

		return gateway.calcularSaldoFuturo(domain);
	}

	public CalculadoraDomain calcularParcelaRecorrente(CalculadoraDomain domain) {

		domain = gateway.calcularParcelaRecorrente(domain);

		if (domain.getValorRecorrente().compareTo(BigDecimal.ZERO) == -1) {
			domain.setValorRecorrente(BigDecimal.ZERO);
			domain.setDescricao("Valor inicial informado R$ " + domain.getValorInicial().setScale(2).toString()
					+ "é suficiente para atingir o valor final desejado.");
		}

		return domain;
	}

	public CalculadoraDomain calcularTempo(CalculadoraDomain domain) {

		domain = gateway.calcularTempo(domain);

		return domain;
	}

	public CalculadoraDomain parceladoVista(CalculadoraDomain domain) {
		
		domain = gateway.calcularSaldoFuturoRecorrente(domain);
		domain.setDescricao("Ao parcelar um produto de R$ " + domain.getValorInicial().setScale(2) + " em " + domain.getQuantidadePeriodos() + " parcelas e investir o valor a um juros de " + domain.getJuros() + "%, você terá economizado R$ " + domain.getValorFinal().setScale(2));

		return gateway.calcularSaldoFuturoRecorrente(domain);

	}

}
