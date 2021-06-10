package br.com.zupacademy.vinicius.propostazup.cartao.biometria;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zupacademy.vinicius.propostazup.cartao.Cartao;

@Entity
public class Biometria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uuid;
	@Column(columnDefinition = "text")
	private String fingerprint;
	private OffsetDateTime criadoEm = OffsetDateTime.now();
	@ManyToOne
	private Cartao cartao;

	public Biometria(String fingerprint, Cartao cartao) {
		this.fingerprint = fingerprint;
		this.cartao = cartao;
		this.uuid = UUID.randomUUID().toString();
	}

	public String getUuid() {
		return uuid;
	}

}
