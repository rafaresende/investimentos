package com.necromato.investimentos.entrypoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.necromato.investimentos.entrypoint.mapper.CalculadoraMapper;
import com.necromato.investimentos.entrypoint.model.request.CalculadoraRequestModel;
import com.necromato.investimentos.entrypoint.model.response.CalculadoraResponseModel;
import com.necromato.investimentos.usecase.CalculadoraUseCase;
import com.necromato.investimentos.usecase.domain.CalculadoraDomain;

@RestController
@RequestMapping("/investimentos/calculadora")
public class CalculadoraController {
	
	@Autowired
	private CalculadoraUseCase usecase;
	
	@GetMapping("/valor-futuro")
	public CalculadoraResponseModel valorFuturo(CalculadoraRequestModel modelResquest) {
		
		CalculadoraDomain domain = CalculadoraMapper.toDomain(modelResquest);
		
		domain = usecase.calcularSaldoFuturo(domain);
		
		return CalculadoraMapper.fromDomainToFuturo(domain);
	}
	
	@GetMapping("/parcela-recorrente")
	public CalculadoraResponseModel parcelaRecorrente(CalculadoraRequestModel modelResquest) {
		
		CalculadoraDomain domain = CalculadoraMapper.toDomain(modelResquest);
		
		domain = usecase.calcularParcelaRecorrente(domain);
		
		return CalculadoraMapper.fromDomainToValorParcela(domain);
	}
	
	@GetMapping("/tempo-aplicacao")
	public CalculadoraResponseModel tempoAplicacao(CalculadoraRequestModel modelResquest) {
		
		CalculadoraDomain domain = CalculadoraMapper.toDomain(modelResquest);
		
		domain = usecase.calcularTempo(domain);
		
		return CalculadoraMapper.fromDomainToTempo(domain);
	}
	
	@GetMapping("/parcelado-vs-vista")
	public CalculadoraResponseModel parceladoVista(CalculadoraRequestModel modelResquest) {
		
		CalculadoraDomain domain = CalculadoraMapper.toDomain(modelResquest);
		
		domain = usecase.parceladoVista(domain);
		
		return CalculadoraMapper.fromDomainToParceladoVista(domain);
	}

}
