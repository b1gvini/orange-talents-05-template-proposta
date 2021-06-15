package br.com.zupacademy.vinicius.propostazup.cartao.carteira;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.vinicius.propostazup.cartao.Cartao;

@Entity
public class Carteira {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	@Enumerated(EnumType.STRING)
	private TipoCarteira carteira;

	@ManyToOne
	private Cartao cartao;
	
	@Deprecated
	public Carteira() {
		
	}

	public Carteira(@Email @NotBlank String email, TipoCarteira carteira, Cartao cartao) {
		this.email = email;
		this.carteira = carteira;
		this.cartao = cartao;
	}

	public String getEmail() {
		return email;
	}

	public TipoCarteira getCarteira() {
		return carteira;
	}

	public Long getId() {
		return id;
	}

	public Cartao getCartao() {
		return cartao;
	}

}
