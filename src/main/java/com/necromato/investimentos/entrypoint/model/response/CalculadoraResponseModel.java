package com.necromato.investimentos.entrypoint.model.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class CalculadoraResponseModel {

	private BigDecimal valorInicial;
	private BigDecimal valorParcelaRecorrente;
	private BigDecimal valorInvestido;
	private String jurosObtido;
	private BigDecimal valorFinal;
	private Integer numerosParcelas;

	public Integer getNumerosParcelas() {
		return numerosParcelas;
	}

	public void setNumerosParcelas(Integer numerosParcelas) {
		this.numerosParcelas = numerosParcelas;
	}

	private String descricao;

	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}

	public BigDecimal getValorParcelaRecorrente() {
		return valorParcelaRecorrente;
	}

	public void setValorParcelaRecorrente(BigDecimal valorParcelaRecorrente) {
		this.valorParcelaRecorrente = valorParcelaRecorrente;
	}

	public BigDecimal getValorInvestido() {
		return valorInvestido;
	}

	public void setValorInvestido(BigDecimal valorInvestido) {
		this.valorInvestido = valorInvestido;
	}

	public String getJurosObtido() {
		return jurosObtido;
	}

	public void setJurosObtido(String jurosObtido) {
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
