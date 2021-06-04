package br.com.zupacademy.vinicius.propostazup.compartilhado.excecoes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErroDTO {

	private String campo;
	private String erro;

	public ErroDTO(String erro) {
		this.erro = erro;
	}

	public ErroDTO(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
