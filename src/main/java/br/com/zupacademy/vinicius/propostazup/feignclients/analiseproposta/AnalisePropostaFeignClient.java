package br.com.zupacademy.vinicius.propostazup.feignclients.analiseproposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "analiseProposta", url = "${api.proposta}")
public interface AnalisePropostaFeignClient {

	@RequestMapping(method = RequestMethod.POST, value = "${api.proposta.solicitacao}")
	AnaliseFeignResponse verifica(AnaliseFeignRequest request);
	
	
}
