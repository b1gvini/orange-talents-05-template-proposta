package br.com.zupacademy.vinicius.propostazup.proposta;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.vinicius.propostazup.cartao.Cartao;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uuid;
	private @NotBlank String documento;
	private @NotBlank String nome;
	private @Email @NotBlank String email;
	private @NotBlank String endereco;
	private @NotNull BigDecimal salario;
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Cartao cartao;

	@Deprecated
	public Proposta() {
	}

	public Proposta(@NotBlank String documento, @NotBlank String nome, @Email @NotBlank String email,
			@NotBlank String endereco, @NotNull BigDecimal salario) {
		this.documento = CriptografarDocumentoProposta.criptografar(documento);
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.salario = salario;
		this.uuid = UUID.randomUUID().toString();
	}

	public String getUuid() {
		return uuid;
	}

	public String getNome() {
		return nome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
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

	public Cartao getCartao() {
		return cartao;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

}
