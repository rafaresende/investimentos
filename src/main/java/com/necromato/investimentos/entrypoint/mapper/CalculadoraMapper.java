package com.necromato.investimentos.entrypoint.mapper;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.necromato.investimentos.entrypoint.model.request.CalculadoraRequestModel;
import com.necromato.investimentos.entrypoint.model.response.CalculadoraResponseModel;
import com.necromato.investimentos.usecase.domain.CalculadoraDomain;

public class CalculadoraMapper {

	public static CalculadoraDomain toDomain(CalculadoraRequestModel request) {

		CalculadoraDomain domain = new CalculadoraDomain();

		domain.setJuros(request.getJuros());
		domain.setQuantidadePeriodos(request.getQuantidadePeriodos());
		domain.setValorInicial(request.getValorInicial());
		domain.setValorRecorrente(request.getValorRecorrente());
		domain.setValorFinal(request.getValorFinal());

		return domain;
	}

	public static CalculadoraResponseModel fromDomainToFuturo(CalculadoraDomain domain) {

		CalculadoraResponseModel response = new CalculadoraResponseModel();

		response.setValorInvestido(domain.getValorInvestido());
		response.setValorFinal(domain.getValorFinal());
		BigDecimal jurosObtido = domain.getJurosObtido();

		if (jurosObtido != null)
			response.setJurosObtido(jurosObtido.setScale(2, RoundingMode.HALF_UP).subtract(BigDecimal.ONE)
					.multiply(BigDecimal.valueOf(100)).toString() + " %");

		return response;
	}

	public static CalculadoraResponseModel fromDomainToTempo(CalculadoraDomain domain) {

		CalculadoraResponseModel response = new CalculadoraResponseModel();

		response.setNumerosParcelas(domain.getQuantidadePeriodos());

		return response;
	}

	public static CalculadoraResponseModel fromDomainToValorParcela(CalculadoraDomain domain) {

		CalculadoraResponseModel response = new CalculadoraResponseModel();

		response.setDescricao(domain.getDescricao());
		response.setValorParcelaRecorrente(domain.getValorRecorrente());

		return response;
	}
	
	public static CalculadoraResponseModel fromDomainToParceladoVista(CalculadoraDomain domain) {

		CalculadoraResponseModel response = new CalculadoraResponseModel();

		response.setDescricao(domain.getDescricao());
		response.setValorFinal(domain.getValorFinal());

		return response;
	}

}
