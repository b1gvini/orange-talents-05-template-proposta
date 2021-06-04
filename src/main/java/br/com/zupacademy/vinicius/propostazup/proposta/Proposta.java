package br.com.zupacademy.vinicius.propostazup.proposta;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uuid;
	private String documento;
	private @Email @NotBlank String email;
	private @NotBlank String endereco;
	private @NotNull BigDecimal salario;
	
	@Deprecated
	public Proposta() {}

	public Proposta(String documento, @Email @NotBlank String email, @NotBlank String endereco,
			@NotNull BigDecimal salario) {
		this.documento = documento;
		this.email = email;
		this.endereco = endereco;
		this.salario = salario;
		this.uuid = UUID.randomUUID().toString();
	}

	public String getUuid() {
		return uuid;
	}
	
}
