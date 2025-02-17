package br.com.zupacademy.vinicius.propostazup.feignclients.analiseproposta;

public class AnaliseFeignResponse {

	private String documento;
	private String nome;
	private String resultadoSolicitacao;
	private String idProposta;
	
	public AnaliseFeignResponse(String documento, String nome, String resultadoSolicitacao, String idProposta) {
		this.documento = documento;
		this.nome = nome;
		this.resultadoSolicitacao = resultadoSolicitacao;
		this.idProposta = idProposta;
	}

	public AnaliseFeignResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public String getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}

	public String getIdProposta() {
		return idProposta;
	}
		
}
