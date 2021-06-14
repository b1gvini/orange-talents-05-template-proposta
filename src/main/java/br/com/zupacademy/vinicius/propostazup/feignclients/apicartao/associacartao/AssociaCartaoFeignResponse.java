package br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.associacartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.vinicius.propostazup.cartao.Cartao;

public class AssociaCartaoFeignResponse {

	private String id;
	private LocalDateTime emitidoEm;
	private String titular;
	private BigDecimal limite;
	private AssociaCartaoVencimentoFeignResponse vencimento;
	private String idProposta;

	public AssociaCartaoFeignResponse(String id, LocalDateTime emitidoEm, String titular, BigDecimal limite,
			AssociaCartaoVencimentoFeignResponse vencimento, String idProposta) {
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

	public AssociaCartaoVencimentoFeignResponse getVencimento() {
		return vencimento;
	}

	public String getIdProposta() {
		return idProposta;
	}
	
	public Cartao toModel() {
		return new Cartao(id, emitidoEm, titular, limite, vencimento.getDia());
	}

}
