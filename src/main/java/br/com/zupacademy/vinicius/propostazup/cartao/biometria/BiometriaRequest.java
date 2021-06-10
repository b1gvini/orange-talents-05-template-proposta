package br.com.zupacademy.vinicius.propostazup.cartao.biometria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.vinicius.propostazup.cartao.Cartao;
import br.com.zupacademy.vinicius.propostazup.compartilhado.validacoes.UniqueValue;

public class BiometriaRequest {

	@IsBase64
	@NotBlank
	@UniqueValue(domainClass = Biometria.class, fieldName = "fingerprint")
	@JsonProperty
	private String fingerprint;
	
	public Biometria toModel(Cartao cartao) {
		return new Biometria(fingerprint, cartao);
	}
}
