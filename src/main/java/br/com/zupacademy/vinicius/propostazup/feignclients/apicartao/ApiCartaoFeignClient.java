package br.com.zupacademy.vinicius.propostazup.feignclients.apicartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.associacartao.AssociaCartaoFeignResponse;
import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.bloqueiocartao.BloqueioCartaoFeignRequest;
import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.bloqueiocartao.BloqueioCartaoFeignResponse;

@FeignClient(name = "AssociaCartao", url = "${api.cartao}")
public interface ApiCartaoFeignClient {

	@RequestMapping(method = RequestMethod.GET, path = "${api.busca.cartao}?idProposta={idProposta}")
	AssociaCartaoFeignResponse consultaCartao(@PathVariable("idProposta") String idProposta);
	
	@RequestMapping(method = RequestMethod.POST, path = "${api.busca.cartao}/{id}/bloqueios")
	BloqueioCartaoFeignResponse bloqueioCartao(@PathVariable("id") String id, BloqueioCartaoFeignRequest request);
}
