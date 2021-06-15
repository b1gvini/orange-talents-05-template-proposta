package br.com.zupacademy.vinicius.propostazup.cartao.carteira;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.vinicius.propostazup.cartao.Cartao;
import br.com.zupacademy.vinicius.propostazup.compartilhado.validacoes.ValueOfEnum;

public class NovaCarteiraRequest {

	@Email @NotBlank
	private String email;
	@NotNull @ValueOfEnum(enumClass = TipoCarteira.class)
	private String carteira;
	
	public NovaCarteiraRequest(@Email @NotBlank String email, @NotBlank String carteira) {
		this.email = email;
		this.carteira = carteira;
	}
	public String getEmail() {
		return email;
	}
	public String getCarteira() {
		return carteira;
	}
	
	public Carteira toModel(Cartao cartao) {
		return new Carteira(email, TipoCarteira.valueOf(carteira), cartao);
	}
}
