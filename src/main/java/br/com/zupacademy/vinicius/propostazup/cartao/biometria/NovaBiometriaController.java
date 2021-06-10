package br.com.zupacademy.vinicius.propostazup.cartao.biometria;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.vinicius.propostazup.cartao.Cartao;
import br.com.zupacademy.vinicius.propostazup.cartao.CartaoRepository;

@RestController
public class NovaBiometriaController {
	
	@Autowired
	private BiometriaRepository biometriaRepository;
	
	@Autowired
	private CartaoRepository cartaoRepository;

	@PostMapping("cartoes/{uuid}/biometrias")
	public ResponseEntity<?> cadastrar(@PathVariable("uuid") String uuid, @RequestBody @Valid BiometriaRequest request, UriComponentsBuilder builder){
		Optional<Cartao> cartao = cartaoRepository.findByUuid(uuid);
		if(cartao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Biometria biometria = request.toModel(cartao.get());
		biometriaRepository.save(biometria);
		return ResponseEntity.ok().build();
		
	}
}
