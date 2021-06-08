package br.com.zupacademy.vinicius.propostazup.proposta;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.zupacademy.vinicius.propostazup.cartao.CartaoResponse;

public class PropostaResponse {

	private String documento;
	private String nome;
	private String email;
	private String endereco;
	private BigDecimal salario;
	private Status status;
	
	@JsonInclude(Include.NON_NULL)
	private CartaoResponse cartao;
	
	public PropostaResponse(Proposta proposta) {
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.email = proposta.getEmail();
		this.endereco = proposta.getEndereco();
		this.salario = proposta.getSalario();
		this.status = proposta.getStatus();
		if(proposta.getCartao() != null) {
			this.cartao = new CartaoResponse(proposta.getCartao());			
		}
	}
	
	public void setCartao(CartaoResponse cartao) {
		this.cartao = cartao;
	}
	public String getDocumento() {
		return documento;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return endereco;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public Status getStatus() {
		return status;
	}
	public CartaoResponse getCartao() {
		return cartao;
	}
	
	
	
}
