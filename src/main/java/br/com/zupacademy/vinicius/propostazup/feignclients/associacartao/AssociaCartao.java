package br.com.zupacademy.vinicius.propostazup.feignclients.associacartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "AssociaCartao", url = "${api.associacartao}")
public interface AssociaCartao {

	@RequestMapping(method = RequestMethod.GET, path = "${api.busca.cartao}?idProposta={idProposta}")
	AssociaCartaoResponse consultaCartao(@PathVariable("idProposta") String idProposta);
}
