package com.necromato.investimentos.usecase.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculadoraDomain {

	private BigDecimal valorInicial;
	private BigDecimal valorRecorrente;
	private BigDecimal juros;
	private Integer quantidadePeriodos;
	private BigDecimal valorFinal;

	private BigDecimal valorInvestido;
	private BigDecimal jurosObtido;

	private String descricao;

	public BigDecimal getValorInvestido() {
		return valorInvestido;
	}

	public void setValorInvestido(BigDecimal valorInvestido) {
		this.valorInvestido = valorInvestido;
	}

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

	public BigDecimal getJurosObtido() {
		return jurosObtido;
	}

	public void setJurosObtido(BigDecimal jurosObtido) {
		this.jurosObtido = jurosObtido;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
