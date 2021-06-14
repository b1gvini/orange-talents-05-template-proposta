package br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.bloqueiocartao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BloqueioCartaoFeignResponse {

	@JsonProperty
	private String resultado;
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public BloqueioCartaoFeignResponse(String resultado) {
		this.resultado = resultado;
	}
	
	public String getResultado() {
		return resultado;
	}
}
