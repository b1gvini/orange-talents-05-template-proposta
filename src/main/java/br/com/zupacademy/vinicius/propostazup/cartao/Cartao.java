package br.com.zupacademy.vinicius.propostazup.cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.vinicius.propostazup.cartao.biometria.Biometria;
import br.com.zupacademy.vinicius.propostazup.cartao.bloqueio.BloqueioCartao;
import br.com.zupacademy.vinicius.propostazup.proposta.Proposta;

@Entity
public class Cartao {

	@Id
	private String id;
	
	private String uuid;
	@NotNull
	private LocalDateTime emitidoEm;
	@NotNull
	private String titular;
	@NotNull
	@Positive
	private BigDecimal limite;
	@NotNull
	private int vencimento;
	
	@Enumerated(EnumType.STRING)
	private StatusCartao status = StatusCartao.NAO_BLOQUEADO;
	
	@OneToMany(mappedBy = "cartao")
	private List<Biometria> biometrias = new ArrayList<>();
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
	private List<BloqueioCartao> bloqueios = new ArrayList<>();
	
	@Deprecated
	public Cartao() {
		
	}

	public Cartao(String id, LocalDateTime emitidoEm, String titular, BigDecimal limite, int vencimento) {
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
		this.vencimento = vencimento;
		this.uuid = UUID.randomUUID().toString();
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
	
	public String getUuid() {
		return uuid;
	}

	public void bloqueia(String ipAddress, String userAgent) {
		this.status = StatusCartao.BLOQUEADO;
		addBloqueio(new BloqueioCartao(ipAddress, userAgent, this));
	}
	
	private void addBloqueio(BloqueioCartao bloqueio) {
		bloqueios.add(bloqueio);
	}
	
	public boolean estaBloqueado() {
		return status.equals(StatusCartao.BLOQUEADO);
	}

}
