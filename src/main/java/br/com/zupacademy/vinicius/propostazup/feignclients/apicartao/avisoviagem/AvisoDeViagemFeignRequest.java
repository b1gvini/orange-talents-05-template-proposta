package br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.avisoviagem;

import java.time.LocalDate;

public class AvisoDeViagemFeignRequest {

	private String destino;
	private LocalDate validoAte;

	public AvisoDeViagemFeignRequest(String destino, LocalDate validoAte) {
		this.destino = destino;
		this.validoAte = validoAte;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDate getValidoAte() {
		return validoAte;
	}

}
