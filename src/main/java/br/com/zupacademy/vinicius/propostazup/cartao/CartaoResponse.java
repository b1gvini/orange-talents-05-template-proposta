package br.com.zupacademy.vinicius.propostazup.cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CartaoResponse {

	private String id;
	private LocalDateTime emitidoEm;
	private String titular;
	private BigDecimal limite;
	private int vencimento;
	
	public CartaoResponse(Cartao cartao) {
		this.id = cartao.getId();
		this.emitidoEm = cartao.getEmitidoEm();
		this.titular = cartao.getTitular();
		this.limite = cartao.getLimite();
		this.vencimento = cartao.getVencimento();
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public int getVencimento() {
		return vencimento;
	}
	
	
}
