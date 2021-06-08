package br.com.zupacademy.vinicius.propostazup.proposta;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vinicius.propostazup.compartilhado.excecoes.ExcecaoGenerica;

@RestController
public class ExibirPropostaController {
	
	@Autowired
	private PropostaRepository propostaRepository;

	@GetMapping("/propostas/{uuid}")
	public ResponseEntity<PropostaResponse> exibir(@PathVariable("uuid") String uuid) throws ExcecaoGenerica{
		Optional<Proposta> possivelProposta = propostaRepository.findByUuid(uuid);
		if(possivelProposta.isEmpty()) {
			throw new ExcecaoGenerica("Proposta inexistente", HttpStatus.NOT_FOUND);
		}
		PropostaResponse response = new PropostaResponse(possivelProposta.get());
		return ResponseEntity.ok(response);
		
	}
}
