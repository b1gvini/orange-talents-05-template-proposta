package br.com.zupacademy.vinicius.propostazup.cartao.viagem;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.vinicius.propostazup.cartao.Cartao;

public class AvisoDeViagemRequest {

	@NotBlank
	private String destinoViagem;
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@NotNull
	@FutureOrPresent
	private LocalDate terminoViagem;
	
	private void setDestinoViagem(String destinoViagem) {
		this.destinoViagem = destinoViagem;
	}
	
	private void setTerminoViagem(LocalDate terminoViagem) {
		this.terminoViagem = terminoViagem;
	}
	
	public String getDestinoViagem() {
		return destinoViagem;
	}

	public LocalDate getTerminoViagem() {
		return terminoViagem;
	}

	public AvisoDeViagem toModel(String ipAddress, String userAgent, Cartao cartao) {
		return new AvisoDeViagem(cartao, destinoViagem, terminoViagem, ipAddress, userAgent);
	}
}
