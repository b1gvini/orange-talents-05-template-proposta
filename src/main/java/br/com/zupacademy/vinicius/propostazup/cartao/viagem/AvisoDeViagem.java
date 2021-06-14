package br.com.zupacademy.vinicius.propostazup.cartao.viagem;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zupacademy.vinicius.propostazup.cartao.Cartao;

@Entity
public class AvisoDeViagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Cartao cartao;
	private String destinoViagem;
	private LocalDate terminoViagem;
	private OffsetDateTime criadoEm = OffsetDateTime.now();
	private String ipAddress;
	private String userAgent;

	@Deprecated
	public AvisoDeViagem() {

	}

	public AvisoDeViagem(Cartao cartao, String destinoViagem, LocalDate terminoViagem, String ipAddress,
			String userAgent) {
		this.cartao = cartao;
		this.destinoViagem = destinoViagem;
		this.terminoViagem = terminoViagem;
		this.ipAddress = ipAddress;
		this.userAgent = userAgent;
	}

}
