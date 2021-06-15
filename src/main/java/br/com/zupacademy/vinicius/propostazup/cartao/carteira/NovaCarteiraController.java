package br.com.zupacademy.vinicius.propostazup.cartao.carteira;

import java.net.URI;
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
import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.ApiCartaoFeignClient;
import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.associacarteira.AssociaCarteiraFeignRequest;
import feign.FeignException;

@RestController
public class NovaCarteiraController {

	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private ApiCartaoFeignClient apiCartao;
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	@PostMapping("/cartoes/{uuid}/carteiras")
	public ResponseEntity<?> cadastrar(@PathVariable("uuid") String uuid, @RequestBody @Valid NovaCarteiraRequest request, UriComponentsBuilder builder){
		Optional<Cartao> possivelCartao = cartaoRepository.findByUuid(uuid);
		if (possivelCartao.isEmpty()){
			return ResponseEntity.notFound().build();
		}
		Cartao cartao = possivelCartao.get();
		Carteira carteira = request.toModel(cartao);
			
		Optional<Carteira> existeCarteira = carteiraRepository.findByCarteiraAndCartaoId(carteira.getCarteira(), carteira.getCartao().getId());
		if(existeCarteira.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		AssociaCarteiraFeignRequest requestFeign = new AssociaCarteiraFeignRequest(cartao.getId(), carteira.getCarteira().toString());
		try{
			apiCartao.associaCarteira(cartao.getId(), requestFeign);
			carteiraRepository.save(carteira);
		}catch(FeignException e){
			return ResponseEntity.unprocessableEntity().build();
		}
		URI path = builder.path("/cartoes/{uuid}/carteiras/{id}").build(cartao.getUuid(),carteira.getId());
		return ResponseEntity.created(path).build();
	}
}
