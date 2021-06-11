package br.com.zupacademy.vinicius.propostazup.cartao.bloqueio;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zupacademy.vinicius.propostazup.cartao.Cartao;

@Entity
public class BloqueioCartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ipAddress;
	private String userAgent;
	private OffsetDateTime bloqueadoEm = OffsetDateTime.now();
	@ManyToOne
	private Cartao cartao;
	
	@Deprecated
	public BloqueioCartao() {
		
	}

	public BloqueioCartao(String ipAddress, String userAgent, Cartao cartao) {
		this.ipAddress = ipAddress;
		this.userAgent = userAgent;
		this.cartao = cartao;
	}

}
