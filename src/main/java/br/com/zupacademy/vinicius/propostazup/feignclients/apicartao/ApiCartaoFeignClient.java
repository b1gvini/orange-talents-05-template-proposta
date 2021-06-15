package br.com.zupacademy.vinicius.propostazup.feignclients.apicartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.associacartao.AssociaCartaoFeignResponse;
import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.avisoviagem.AvisoDeViagemFeignRequest;
import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.avisoviagem.AvisoDeViagemFeignResponse;
import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.bloqueiocartao.BloqueioCartaoFeignRequest;
import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.bloqueiocartao.BloqueioCartaoFeignResponse;

@FeignClient(name = "AssociaCartao", url = "${api.cartao}")
public interface ApiCartaoFeignClient {

	//Associa cartão.
	@RequestMapping(method = RequestMethod.GET, path = "${api.busca.cartao}?idProposta={idProposta}")
	AssociaCartaoFeignResponse consultaCartao(@PathVariable("idProposta") String idProposta);
	//Bloqueio de cartão.
	@RequestMapping(method = RequestMethod.POST, path = "${api.busca.cartao}/{id}/bloqueios")
	BloqueioCartaoFeignResponse bloqueioCartao(@PathVariable("id") String id, BloqueioCartaoFeignRequest request);
	//Aviso de viagem.
	@RequestMapping(method = RequestMethod.POST, path = "${api.busca.cartao}/{id}/avisos")
	AvisoDeViagemFeignResponse avisaViagem(@PathVariable("id") String id, AvisoDeViagemFeignRequest request);
	
}
