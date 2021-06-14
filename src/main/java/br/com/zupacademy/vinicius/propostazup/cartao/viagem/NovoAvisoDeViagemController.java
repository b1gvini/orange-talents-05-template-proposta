package br.com.zupacademy.vinicius.propostazup.cartao.viagem;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vinicius.propostazup.cartao.Cartao;
import br.com.zupacademy.vinicius.propostazup.cartao.CartaoRepository;

@RestController
public class NovoAvisoDeViagemController {
	
	private final Logger logger = LoggerFactory.getLogger(NovoAvisoDeViagemController.class);
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private AvisoDeViagemRepository viagemRepository;

	@PostMapping("/cartoes/{uuid}/viagens")
	public ResponseEntity<?> cadastrar(@PathVariable("uuid") String uuid, @RequestBody @Valid AvisoDeViagemRequest request, HttpServletRequest http){
		Optional<Cartao> possivelCartao= cartaoRepository.findByUuid(uuid);
		if (possivelCartao.isEmpty()) {
			logger.error("Cartão Não Encontrado");
			return ResponseEntity.notFound().build();
		}
		Cartao cartao = possivelCartao.get();
		String ipAddress = http.getRemoteAddr();
		String userAgent = http.getHeader("User-Agent");
		AvisoDeViagem viagem = request.toModel(ipAddress, userAgent, cartao);
		viagemRepository.save(viagem);
		return ResponseEntity.ok().build();
		
	}
}
