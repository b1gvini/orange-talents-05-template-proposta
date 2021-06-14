package br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.bloqueiocartao;

public class BloqueioCartaoFeignRequest {

	public String sistemaResponsavel;
	
	public BloqueioCartaoFeignRequest(String sistemaResposavel) {
		this.sistemaResponsavel = sistemaResposavel;
	}
}
