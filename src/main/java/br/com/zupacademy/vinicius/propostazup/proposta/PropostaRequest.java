package br.com.zupacademy.vinicius.propostazup.proposta;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.vinicius.propostazup.compartilhado.CPFOrCNPJ;

public class PropostaRequest {

	@CPFOrCNPJ
	@NotBlank
	private String documento;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String endereco;
	@NotNull
	@Positive
	private BigDecimal salario;

	public PropostaRequest(String documento, String email, String endereco, BigDecimal salario) {
		this.documento = documento;
		this.email = email;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Proposta toModel() {
		return new Proposta(documento, email, endereco, salario);
	}
}
