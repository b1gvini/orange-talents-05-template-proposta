package br.com.zupacademy.vinicius.propostazup.proposta;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.vinicius.propostazup.compartilhado.validacoes.CPFOrCNPJ;

public class PropostaRequest {

	@CPFOrCNPJ
	@NotBlank
	private String documento;
	@NotBlank
	private String nome;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String endereco;
	@NotNull
	@Positive
	private BigDecimal salario;

	public PropostaRequest(String documento, String nome, String email, String endereco, BigDecimal salario) {
		this.documento = documento;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Proposta toModel() {
		return new Proposta(documento, nome, email, endereco, salario);
	}

	public String getDocumento() {
		return documento;
	}
}
