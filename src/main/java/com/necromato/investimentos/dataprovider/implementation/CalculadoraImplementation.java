package com.necromato.investimentos.dataprovider.implementation;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.necromato.investimentos.usecase.domain.CalculadoraDomain;
import com.necromato.investimentos.usecase.gateway.CalculadoraGateway;

@Component
public class CalculadoraImplementation implements CalculadoraGateway {

	private static final BigDecimal CEM = BigDecimal.valueOf(100);
	private BigDecimal jurosDecimal;
	private BigDecimal jurosDecimalMaisUmElevadoN;
	
	@Override
	public CalculadoraDomain calcularSaldoFuturo(CalculadoraDomain domain) {
		
		jurosDecimal = domain.getJuros().divide(CEM);
		jurosDecimalMaisUmElevadoN = jurosDecimal.add(BigDecimal.ONE).pow(domain.getQuantidadePeriodos());
		
		BigDecimal jurosObtido = jurosDecimalMaisUmElevadoN;
		BigDecimal valorFinal = domain.getValorInicial().multiply(jurosObtido).setScale(2, RoundingMode.HALF_UP);

		domain.setJurosObtido(jurosObtido);
		domain.setValorFinal(valorFinal);
		return domain;
	}

	@Override
	public CalculadoraDomain calcularSaldoFuturoRecorrente(CalculadoraDomain domain) {
		jurosDecimal = domain.getJuros().divide(CEM);
		jurosDecimalMaisUmElevadoN = jurosDecimal.add(BigDecimal.ONE).pow(domain.getQuantidadePeriodos());
		
		BigDecimal parteRecorrente = domain.getValorRecorrente().multiply(jurosDecimalMaisUmElevadoN.subtract(BigDecimal.ONE)).divide(jurosDecimal);
		BigDecimal parteInicial = domain.getValorInicial().multiply(jurosDecimalMaisUmElevadoN);
		BigDecimal valorFinal = parteRecorrente.add(parteInicial).setScale(2, RoundingMode.HALF_UP);
		
		BigDecimal valorInvestido = domain.getValorInicial().add(domain.getValorRecorrente().multiply(BigDecimal.valueOf(domain.getQuantidadePeriodos())));
		
		if(valorInvestido.compareTo(BigDecimal.ZERO) == 1) {
			BigDecimal jurosObtido = valorFinal.divide(valorInvestido, 2, RoundingMode.HALF_UP);
			
			domain.setJurosObtido(jurosObtido);
		}
		
		domain.setValorFinal(valorFinal);
		domain.setValorInvestido(valorInvestido);
		
		return domain;
	}

	@Override
	public CalculadoraDomain calcularParcelaRecorrente(CalculadoraDomain domain) {
		jurosDecimal = domain.getJuros().divide(CEM);
		jurosDecimalMaisUmElevadoN = jurosDecimal.add(BigDecimal.ONE).pow(domain.getQuantidadePeriodos());
		
		BigDecimal p1 = domain.getValorFinal().multiply(jurosDecimal);
		BigDecimal p2 = domain.getValorInicial().multiply(jurosDecimalMaisUmElevadoN).multiply(jurosDecimal);
		BigDecimal p3 = jurosDecimalMaisUmElevadoN.subtract(BigDecimal.ONE);
		domain.setValorRecorrente(p1.subtract(p2).divide(p3, 2, RoundingMode.DOWN));
		
		return domain;
	}

	@Override
	public CalculadoraDomain calcularTempo(CalculadoraDomain domain) {
		
		jurosDecimal = domain.getJuros().divide(CEM);
		
		BigDecimal jurosDecimalMaisUm = jurosDecimal.add(BigDecimal.ONE);
		
		BigDecimal p1 = domain.getValorFinal().multiply(jurosDecimal).add(domain.getValorRecorrente());
		BigDecimal p2 = domain.getValorRecorrente().add(domain.getValorInicial().multiply(jurosDecimal));
		BigDecimal x = p1.divide(p2, 20, RoundingMode.HALF_UP);
		
		Integer numParcelas = 1;
		
		while(jurosDecimalMaisUm.pow(numParcelas).compareTo(x) == -1) {
			numParcelas++;
		}
		
		domain.setQuantidadePeriodos(numParcelas);
		
		return domain;
	}

}
