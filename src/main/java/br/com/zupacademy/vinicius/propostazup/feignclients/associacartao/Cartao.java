package br.com.zupacademy.vinicius.propostazup.feignclients.associacartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.vinicius.propostazup.proposta.Proposta;

@Entity
public class Cartao {

	@Id
	private String id;
	@NotNull
	private LocalDateTime emitidoEm;
	@NotNull
	private String titular;
	@NotNull
	@Positive
	private BigDecimal limite;
	@NotNull
	private int vencimento;
	
	@Deprecated
	public Cartao() {
		
	}

	public Cartao(String id, LocalDateTime emitidoEm, String titular, BigDecimal limite, int vencimento) {
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
		this.vencimento = vencimento;
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
