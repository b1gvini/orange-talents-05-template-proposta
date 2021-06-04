package br.com.zupacademy.vinicius.propostazup.compartilhado.excecoes;

public class ErroDTO {
	
	private String campo;
	private String erro;
	
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
