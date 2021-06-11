package br.com.zupacademy.vinicius.propostazup.cartao;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BloqueiaCartaoController {
	
	@Autowired
	private CartaoRepository cartaoRepository;

	@PostMapping("/cartoes/{uuid}/bloqueios")
	public ResponseEntity<?> pedidoBloqueio(@PathVariable String uuid, HttpServletRequest http) {
		Optional<Cartao> possivelCartao= cartaoRepository.findByUuid(uuid);
		if (possivelCartao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Cartao cartao = possivelCartao.get();
		
		if (cartao.estaBloqueado()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		String ipAddress = http.getRemoteAddr();
		String userAgent = http.getHeader("User-Agent");
		cartao.bloqueia(ipAddress, userAgent);
		cartaoRepository.save(cartao);
		return ResponseEntity.ok().build();
	}
}
