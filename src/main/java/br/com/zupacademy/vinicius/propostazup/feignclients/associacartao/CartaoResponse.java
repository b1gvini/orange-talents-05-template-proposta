package br.com.zupacademy.vinicius.propostazup.feignclients.associacartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CartaoResponse {

	private String id;
	private LocalDateTime emitidoEm;
	private String titular;
	private BigDecimal limite;
	private VencimentoResponse vencimento;
	private String idProposta;

	public CartaoResponse(String id, LocalDateTime emitidoEm, String titular, BigDecimal limite,
			VencimentoResponse vencimento, String idProposta) {
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
		this.vencimento = vencimento;
		this.idProposta = idProposta;
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

	public VencimentoResponse getVencimento() {
		return vencimento;
	}

	public String getIdProposta() {
		return idProposta;
	}
	
	public Cartao toModel() {
		return new Cartao(id, emitidoEm, titular, limite, vencimento.getDia());
	}

}
