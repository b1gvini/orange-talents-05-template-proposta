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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.zupacademy.vinicius.propostazup.compartilhado.excecoes.ExcecaoGenerica;
import br.com.zupacademy.vinicius.propostazup.feignclients.analiseproposta.AnalisePropostaFeignClient;
import br.com.zupacademy.vinicius.propostazup.metricas.MetricasPropostas;
import br.com.zupacademy.vinicius.propostazup.feignclients.analiseproposta.AnaliseFeignRequest;
import br.com.zupacademy.vinicius.propostazup.feignclients.analiseproposta.AnaliseFeignResponse;
import feign.FeignException.UnprocessableEntity;

@RestController
public class CriaPropostaController {

	@Autowired
	private PropostaRepository repository;

	@Autowired
	private AnalisePropostaFeignClient analiseFinanceiro;
	
	@Autowired
	private MetricasPropostas metricas;

	@PostMapping("/propostas")
	ResponseEntity<?> criaProposta(@RequestBody @Valid PropostaRequest request,
			UriComponentsBuilder uriComponentsBuilder)
			throws ExcecaoGenerica, JsonMappingException, JsonProcessingException {

		Optional<Proposta> possivelProposta = repository.findByDocumento(request.getDocumento());
		if (possivelProposta.isPresent()) {
			throw new ExcecaoGenerica("CPF ou CNPJ já existe", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		Proposta proposta = request.toModel();
		repository.save(proposta);
		metricas.incrementa();

		// Elegível codigo 2**, Ñ elegível código 422.
		validaPropostaComServidorExterno(proposta);
		// Atualiza Status proposta.
		repository.save(proposta);

		URI uriLocation = uriComponentsBuilder.path("/propostas/{uuid}").build(proposta.getUuid());
		return ResponseEntity.created(uriLocation).build();
	}

	private void validaPropostaComServidorExterno(Proposta proposta)
			throws JsonMappingException, JsonProcessingException {
		try {
			analiseFinanceiro.verifica(new AnaliseFeignRequest(proposta));
			proposta.setStatus(Status.ELEGIVEL);

		} catch (UnprocessableEntity ex) {
			String conteudo = ex.contentUTF8();
			AnaliseFeignResponse response = new ObjectMapper().readValue(conteudo, AnaliseFeignResponse.class);
			if (response.getResultadoSolicitacao().equals("COM_RESTRICAO")) {
				proposta.setStatus(Status.NAO_ELEGIVEL);
			}

		}
	}
}
