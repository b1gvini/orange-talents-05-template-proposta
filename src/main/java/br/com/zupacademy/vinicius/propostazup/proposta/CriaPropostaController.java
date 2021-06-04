package br.com.zupacademy.vinicius.propostazup.proposta;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CriaPropostaController {

	@Autowired
	PropostaRepository repository;

	@PostMapping("/propostas")
	ResponseEntity<?> criaProposta(@RequestBody @Valid PropostaRequest request,
			UriComponentsBuilder uriComponentsBuilder) {

		Proposta proposta = request.toModel();
		repository.save(proposta);
		URI uriLocation = uriComponentsBuilder.path("/propostas/{uuid}").build(proposta.getUuid());
		return ResponseEntity.created(uriLocation).build();
	}
}
