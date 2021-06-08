package br.com.zupacademy.vinicius.propostazup.feignclients.analiseproposta;

import br.com.zupacademy.vinicius.propostazup.proposta.Proposta;

public class AnaliseRequest {

	private String nome;
	private String documento;
	private String idProposta;
	
	public AnaliseRequest(Proposta proposta) {
		this.nome = proposta.getNome();
		this.documento = proposta.getDocumento();
		this.idProposta = proposta.getUuid();
	}

	public String getNome() {
		return nome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getIdProposta() {
		return idProposta;
	}

}
