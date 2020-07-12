package com.necromato.investimentos.entrypoint.model.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculadoraRequestModel {

	private BigDecimal valorInicial;
	private BigDecimal valorRecorrente;
	private BigDecimal juros;
	private Integer quantidadePeriodos;
	private BigDecimal valorFinal;

	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}

	public BigDecimal getValorRecorrente() {
		return valorRecorrente;
	}

	public void setValorRecorrente(BigDecimal valorRecorrente) {
		this.valorRecorrente = valorRecorrente;
	}

	public BigDecimal getJuros() {
		return juros;
	}

	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	public Integer getQuantidadePeriodos() {
		return quantidadePeriodos;
	}

	public void setQuantidadePeriodos(Integer quantidadePeriodos) {
		this.quantidadePeriodos = quantidadePeriodos;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

}
