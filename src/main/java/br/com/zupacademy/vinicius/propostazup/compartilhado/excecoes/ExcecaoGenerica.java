package br.com.zupacademy.vinicius.propostazup.compartilhado.excecoes;

import org.springframework.http.HttpStatus;

public class ExcecaoGenerica extends Throwable {

	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	
	public ExcecaoGenerica(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
