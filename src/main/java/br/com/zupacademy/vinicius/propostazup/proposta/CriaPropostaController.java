package br.com.zupacademy.vinicius.propostazup.proposta;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.vinicius.propostazup.compartilhado.excecoes.ExcecaoGenerica;

@RestController
public class CriaPropostaController {

	@Autowired
	private PropostaRepository repository;

	@PostMapping("/propostas")
	ResponseEntity<?> criaProposta(@RequestBody @Valid PropostaRequest request,
			UriComponentsBuilder uriComponentsBuilder) throws ExcecaoGenerica {
		
		Optional<Proposta> possivelProposta = repository.findByDocumento(request.getDocumento());
		if(possivelProposta.isPresent()) {
			throw new ExcecaoGenerica("CPF ou CNPJ já existe", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		Proposta proposta = request.toModel();
		repository.save(proposta);
		URI uriLocation = uriComponentsBuilder.path("/propostas/{uuid}").build(proposta.getUuid());
		return ResponseEntity.created(uriLocation).build();
	}
}
