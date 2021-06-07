package br.com.zupacademy.vinicius.propostazup.apisexternas;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "analiseFinanceiro", url = "${apiexternas.analisefinanceiro}")
public interface AnaliseFinanceiro {

	@RequestMapping(method = RequestMethod.POST, value = "${apiexternas.request}")
	AnaliseResponse verifica(AnaliseRequest request);
}
