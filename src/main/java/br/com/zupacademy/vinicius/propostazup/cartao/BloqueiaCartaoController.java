package br.com.zupacademy.vinicius.propostazup.cartao;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.ApiCartaoFeignClient;
import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.bloqueiocartao.BloqueioCartaoFeignRequest;
import feign.FeignException;

@RestController
public class BloqueiaCartaoController {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private ApiCartaoFeignClient apiCartao;
	
	private final Logger logger = LoggerFactory.getLogger(BloqueiaCartaoController.class);

	@PostMapping("/cartoes/{uuid}/bloqueios")
	public ResponseEntity<?> pedidoBloqueio(@PathVariable String uuid, HttpServletRequest http) {
		Optional<Cartao> possivelCartao= cartaoRepository.findByUuid(uuid);
		if (possivelCartao.isEmpty()) {
			logger.error("Cartão Não Encontrado");
			return ResponseEntity.notFound().build();
		}
		
		Cartao cartao = possivelCartao.get();
		String ipAddress = http.getRemoteAddr();
		String userAgent = http.getHeader("User-Agent");
		
		if (cartao.estaBloqueado()) {
			logger.error("Cartão Já Bloqueado");
			return ResponseEntity.unprocessableEntity().build();
		}
		//Feign
		
		BloqueioCartaoFeignRequest requestFeign = new BloqueioCartaoFeignRequest("proposta-app");
		try {
			apiCartao.bloqueioCartao(cartao.getId(), requestFeign);
			cartao.bloqueia(ipAddress, userAgent);
			cartaoRepository.save(cartao);
			return ResponseEntity.ok().build();
		} catch (FeignException e) {
			logger.error("Falha de comunicacao com API Bloqueio de Cartões.");
			return ResponseEntity.unprocessableEntity().build();
			
		}
	}
}
